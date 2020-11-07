CREATE DATABASE tiquetes_actualizacion;


CREATE TYPE t_estado AS ENUM('Activo', 'Inactivo');
CREATE TYPE category AS ENUM('Control', 'Administrador');
CREATE TYPE t_destino AS ENUM('Sur', 'Norte','Norte/Sur');

CREATE TABLE IF NOT EXISTS establecimiento (
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    nit INT NOT NULL CHECK (nit > 0),
    descripcion varchar(150),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuario(
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    contrasena VARCHAR NOT NULL,
    username VARCHAR(50) NOT NULL,
    establecimiento_id INT NOT NULL REFERENCES establecimiento(id),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO usuario( nombre, apellido contrasena, username, establecimiento_id) VALUES ('jhonny stiven', 'agudelo tenorio', 12345, 'ctjhonny', 1);

CREATE TABLE IF NOT EXISTS sesion(
    id SERIAL PRIMARY KEY NOT NULL,
    usuario_id INT NOT NULL REFERENCES usuario(id),
    f_comienzo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    f_fin TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS rol(
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuario_rol(
    id SERIAL PRIMARY KEY NOT NULL,
    usuario_id INT NOT NULL REFERENCES usuario(id),
    rol_id INT NOT NULL REFERENCES rol(id),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS control(
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    codigo VARCHAR(20) NOT NULL,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuario_control(
    id SERIAL PRIMARY KEY NOT NULL,
    usuario_id INT NOT NULL REFERENCES usuario(id),
    control_id INT NOT NULL REFERENCES control(id),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS origen(
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    c_codigo INT NOT NULL,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS destino(
    id SERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    c_codigo INT NOT NULL,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS vehiculo(
    id SERIAL PRIMARY KEY NOT NULL,
    n_interno INT NOT NULL,
    placa VARCHAR(50) NOT NULL UNIQUE,
    capacidad INT NOT NULL,
    establecimiento_id INT NOT NULL REFERENCES establecimiento(id),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS conduce (
    id SERIAL NOT NULL PRIMARY KEY,
    vehiculo_id INT NOT NULL REFERENCES vehiculo(id),
    c_conduce INT NOT NULL CHECK (c_conduce > 1 ) UNIQUE,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS rodamiento(
    id SERIAL NOT NULL PRIMARY KEY,
    vehiculo_id INT NOT NULL REFERENCES vehiculo(id),
    conduce_id INT NOT NULL REFERENCES conduce(id),
    h_salida TIME NOT NULL,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tiquete(
    id SERIAL PRIMARY KEY NOT NULL,
    rodamiento_id INT NOT NULL REFERENCES rodamiento(id),
    f_compra DATE NOT NULL DEFAULT CURRENT_DATE,
    h_compra TIME NOT NULL DEFAULT CURRENT_TIME,
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tiquete_detalle(
    id SERIAL NOT NULL PRIMARY KEY,
    tiquete_id INT NOT NULL REFERENCES tiquete(id),
    origen INT NOT NULL REFERENCES origen(id),
    descripcion_id INT NOT NULL REFERENCES destino(id),
    cantidad INT NOT NULL CHECK (cantidad >=1 ),
    estado t_estado DEFAULT 'Activo',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




INSERT INTO usuario( nombre, apellido, contrasena, username, establecimiento_id) VALUES ('jair', 'arisa', 12345, 'ctjair', 1);
INSERT INTO rol (nombre, descripcion) VALUES ('Administrador', 'determina quien interactua en el software'), ('Control', 'Persona que genera rodamientos y tirillas');

INSERT INTO origen(nombre,c_codigo) VALUES ('Tulua',76834),('Zarzal',76895),('Obando',76497),('Cartago',76147),('Andalucia',76036),('Bugalagrande',76113),('Uribe',50370),('La victoria',76403),('San pedro', 05664),('Sonso',05756),('Guacari',76318),('Cerrito',76248),('Cali',76001);


INSERT INTO destino(nombre,c_codigo) VALUES ('Palmira',76520),('Buga',76111),('Tulua',76834),('Zarzal',76895),('Obando',76497),('Cartago',76147),('Andalucia',76036),('Bugalagrande',76113),('Uribe',50370),('La victoria',76403),('San pedro', 05664),('Sonso',05756),('Guacari',76318),('Cerrito',76248),('Cali',76001);

SELECT u.username
    ,u.nombre
    ,u.apellido
    ,u.estado
    ,contrasena
    ,u.id
    ,r.nombre
    FROM usuario u
        INNER JOIN usuario_rol u_r
            ON  u.id = u_r.usuario_id
        INNER JOIN rol r
            ON r.id = u_r.rol_id
    WHERE TRUE
    AND u.username = 'ctjhonny'
    AND u.contrasena = '12345'
    AND U.estado = 'Activo';

-- Agregar a sesion
INSERT INTO sesion (usuario_id) 
    SELECT
        ( SELECT id 
            FROM usuario 
            WHERE username = 'ctjhonny');



-- MOSTRAR RODAMIENTO
    CREATE OR REPLACE FUNCTION m_rodamiento(OUT vehiculo INT, OUT conduce NUMERIC, OUT salida TIME, OUT despacho DATE, OUT estado VARCHAR) 
        RETURNS SETOF record AS $rodamiento$
            SELECT
                v.n_interno
                ,c_conduce
                ,r.h_salida
                ,r.d_despacho
                ,CASE 
                    WHEN CURRENT_TIME > r.h_salida 
                        THEN 'En ruta'
                    ELSE 'Parqueado'
                END estado
            FROM rodamiento r
                INNER JOIN vehiculo v
                    ON v.id = r.vehiculo_id
                INNER JOIN conduce c
                    ON c.created_at = r.created_at
            WHERE TRUE
            AND CURRENT_DATE::TIMESTAMP <= r.created_at
            AND h_salida IS NOT NULL
            ORDER BY r.id;
        $rodamiento$
    LANGUAGE sql;

-- AGREGAR RODAMIENTO
CREATE OR REPLACE FUNCTION g_rodamiento() RETURNS TRIGGER
    AS $guardar_rodamiento$
        BEGIN
            IF(TG_OP = 'INSERT') THEN
                INSERT INTO rodamiento (
                    vehiculo_id
                )
                SELECT
                    NEW.vehiculo_id
                FROM vehiculo v
                WHERE TRUE
                    AND v.id = new.vehiculo_id;
            END IF;
            RETURN NEW;
            END;
    $guardar_rodamiento$
LANGUAGE plpgsql VOLATILE;

CREATE TRIGGER d_insertar_conduce
AFTER INSERT ON conduce
FOR EACH ROW
EXECUTE PROCEDURE g_rodamiento;

-- Mostrar lista vehiculoar de rodamiento
SELECT 
    r.id
    v.n_interno
FROM rodamiento r
    INNER JOIN vehiculo v
        ON v.id = r.vehiculo_id
    WHERE TRUE
    AND CURRENT_DATE::TIMESTAMP <= r.created_at
    ORDER BY r.created_at DESC LIMIT 5;

-- Mostrar vehiculos
CREATE OR REPLACE FUNCTION m_vehiculos(OUT n_interno INT, OUT placa VARCHAR, OUT capacidad INT, OUT compañia VARCHAR, OUT estado t_estado)
    RETURNS SETOF record 
        AS $mostrar_vehiculos$
            SELECT 
                v.n_interno
                ,v.placa
                ,v.capacidad
                ,e.nombre
                ,v.estado
            FROM vehiculo v
                INNER JOIN establecimiento e
                    ON e.id = v.establecimiento_id
            WHERE TRUE
            ORDER BY v.id
        $mostrar_vehiculos$
LANGUAGE sql;
                
-- Mostrar conduces
CREATE OR REPLACE FUNCTION m_conduce(OUT vehiculo INT, OUT conduce NUMERIC ) 
    RETURNS SETOF record AS $$
        SELECT
            v.n_interno
            ,c.c_conduce
            FROM conduce c
                INNER JOIN vehiculo v
                    ON c.vehiculo_id = v.id
        WHERE TRUE
        AND CURRENT_DATE::TIMESTAMP <= c.created_at
        ORDER BY c.id;
    $$
    LANGUAGE sql;


-- //Listar el rodamiento

CREATE OR REPLACE FUNCTION l_rodamiento()
    RETURNS table (vehiculo INT, n_interno INT) 
    AS
     $$
            SELECT DISTINCT
                v.id  
                ,v.n_interno
                FROM vehiculo v
                INNER JOIN rodamiento r
                ON v.id = r.vehiculo_id
            WHERE TRUE 
            AND CURRENT_DATE::timestamp <= r.created_at
            ORDER BY v.n_interno;
    $$
LANGUAGE sql;


-- Agregar Conduces
CREATE OR REPLACE FUNCTION g_conduce( interno INT,conduce INT) RETURNS VOID AS $$
    BEGIN
        INSERT INTO conduce(
            c_conduce
            ,vehiculo_id
        )
        SELECT conduce,
            v.id 
FROM vehiculo v
WHERE TRUE
    AND v.id = interno;
END;
$$ LANGUAGE plpgsql VOLATILE;

-- actualziar rodamiento 
CREATE OR REPLACE FUNCTION actualizar_r(vehiculo INT, hora TIME) RETURNS VOID
    AS $actualizar_rodamiento$
    BEGIN
        UPDATE rodamiento SET h_salida = hora WHERE id =(SELECT MAX(id) 
                FROM rodamiento 
                    WHERE TRUE 
                    AND vehiculo_id = vehiculo
                    AND CURRENT_DATE::timestamp <= created_at
                    AND hora >= CURRENT_TIME
                    GROUP BY vehiculo_id;
                    );
    END;   
    $actualizar_rodamiento$
LANGUAGE plpgsql VOLATILE;  


-- listar usuario
SELECT 
    INITCAP(u.nombre)
    ,INITCAP(u.apellido)
    ,u.username
    ,r.nombre
    ,c.nombre
    ,u.estado
FROM usuario u
    INNER JOIN usuario_rol u_r
        ON u.id = u_r.usuario_id
    INNER JOIN  rol r
        ON r.id = u_r.rol_id
    LEFT JOIN usuario_control u_c
        ON u.id = u_c.usuario_id
    LEFT JOIN control c
        ON c.id = u_c.control_id
WHERE TRUE;

-- listar vehiculos para tiquetes

    SELECT v.n_interno
    FROM vehiculo v
        INNER JOIN rodamiento r
            ON r.vehiculo_id = v.id
    WHERE TRUE
        AND CURRENT_DATE::TIMESTAMP <= r.created_at
        AND r.h_salida >= CURRENT_TIME
        AND r.h_salida IS NOT NULL
        ORDER BY r.id;



--GUARDAR TIQUETE_DETALLE


CREATE OR REPLACE FUNCTION detalle_venta(origen INT, destino INT, cantidad INT, vehiculo INT)
    RETURNS VOID 
        AS 
            $$
                BEGIN
                    INSERT INTO tiquete_detalle
                        (tiquete_id, origen_id, destino_id, cantidad)
                        SELECT max(t_k.id), 
                                origen, 
                                destino, 
                                cantidad
                            FROM tiquete t_k
                                INNER JOIN rodamiento r
                                    ON t_k.rodamiento_id = r.id
                                INNER JOIN vehiculo v
                                    ON v.id = r.vehiculo_id
                                WHERE TRUE
                                    AND CURRENT_DATE::timestamp <= t_k.created_at
                                    AND r.vehiculo_id = vehiculo
                                    GROUP BY t_k.rodamiento_id;
                        IF NOT FOUND THEN
                            RAISE EXCEPTION 'numero del tiquete % no encontrado', t_k.id;
                        END IF;
                END;
            $$
    LANGUAGE plpgsql VOLATILE;


-- Agregar Conduces
CREATE OR REPLACE FUNCTION g_conduce( interno INT,conduce INT) RETURNS VOID AS $$
    BEGIN
        INSERT INTO conduce(
            c_conduce
            ,vehiculo_id
        )
        SELECT conduce,
            v.id 
FROM vehiculo v
WHERE TRUE
    AND v.id = interno;
END;
$$ LANGUAGE plpgsql VOLATILE;


-- AGREGAR tiquete
CREATE OR REPLACE FUNCTION g_tiquete() RETURNS TRIGGER
    AS $guardar_tiquete$
        BEGIN
            IF(TG_OP = 'INSERT') THEN
                INSERT INTO tiquete (
                    rodamiento_id
                )
                SELECT
                    NEW.id
                FROM rodamiento r
                WHERE TRUE
                    AND r.id = new.rodamiento_id;
            END IF;
            RETURN NEW;
            END;
    $guardar_tiquete$
LANGUAGE plpgsql VOLATILE;

CREATE TRIGGER d_insertar_tiquete
AFTER UPDATE OF h_salida ON rodamiento
FOR EACH ROW
EXECUTE PROCEDURE g_tiquete();


-- Mostrar tiquetes comprados
CREATE OR REPLACE FUNCTION m_tiquetes(OUT interno INT, OUT salida TIME, OUT destino VARCHAR, OUT cantidad INT) 
    RETURNS SETOF record
        AS $$ 
            SELECT 
                v.n_interno
                ,r.h_salida
                ,d.nombre
                ,t_d.cantidad
                FROM tiquete t
                    INNER JOIN tiquete_detalle t_d
                        ON t.id = t_d.tiquete_id
                    INNER JOIN destino d
                        ON t_d.destino_id = d.id
                    INNER JOIN rodamiento r
                        ON t.rodamiento_id = r.id
                    INNER JOIN vehiculo v
                        ON v.id = r.vehiculo_id
            WHERE TRUE
            AND CURRENT_DATE::TIMESTAMP <= t_d.created_at
            AND r.h_salida >= CURRENT_TIME
            ORDER BY r.h_salida;
        $$
    LANGUAGE sql;


    ---imprimir QR

CREATE OR REPLACE FUNCTION imprimir_qr() RETURNS TABLE (fecha VARCHAR, hora VARCHAR, nit INT, placa VARCHAR, origen INT, destino INT, conduce NUMERIC, n_qr INT)
    AS 
        $$
            SELECT 
                TO_CHAR(r.d_despacho, 'dd/mm/yyyy') AS dia
                ,TO_CHAR(r.h_salida, 'HH24:MI') AS hora
                ,e.nit
                ,v.placa
                ,o.c_codigo
                ,d.c_codigo
                ,c.c_conduce
                ,t.id
            FROM tiquete t
                INNER JOIN tiquete_detalle t_d
                    ON t.id = t_d.tiquete_id
                INNER JOIN origen o
                    ON t_d.origen_id = o.id
                INNER JOIN destino d
                    ON t_d.destino_id = d.id
                INNER JOIN rodamiento r
                    ON t.rodamiento_id = r.id
                INNER JOIN vehiculo v
                    ON v.id = r.vehiculo_id
                INNER JOIN conduce c
                    ON v.id = c.vehiculo_id
                INNER JOIN establecimiento e
                    ON e.id = v.establecimiento_id
            WHERE TRUE
            AND CURRENT_DATE::TIMESTAMP <= t_d.created_at
            ORDER BY t_d.id DESC
            LIMIT 1;
        $$
LANGUAGE sql;


CREATE OR REPLACE FUNCTION datostiquete() RETURNS 
    TABLE (establecimiento VARCHAR, destino VARCHAR)
        AS
            $$
                SELECT 
                    e.nombre
                    ,d.nombre
                FROM tiquete t
                INNER JOIN tiquete_detalle t_d
                    ON t.id = t_d.tiquete_id
                INNER JOIN destino d
                    ON t_d.destino_id = d.id
                INNER JOIN rodamiento r
                    ON t.rodamiento_id = r.id
                INNER JOIN vehiculo v
                    ON v.id = r.vehiculo_id
                INNER JOIN establecimiento e
                    ON e.id = v.establecimiento_id
            WHERE TRUE
                AND CURRENT_DATE::TIMESTAMP <= t_d.created_at
                ORDER BY t_d.id DESC LIMIT 1;
        $$
LANGUAGE sql;





            SELECT
                v.n_interno
                ,c_conduce
                ,r.h_salida
                ,r.d_despacho
                ,CASE 
                    WHEN CURRENT_TIME > r.h_salida 
                        THEN 'En ruta'
                    ELSE 'parqueado'
                END estado
            FROM rodamiento r
                INNER JOIN vehiculo v
                    ON v.id = r.vehiculo_id
                INNER JOIN conduce c
                    ON c.created_at = r.created_at
            WHERE TRUE
            AND CURRENT_DATE::TIMESTAMP <= r.created_at
            AND h_salida IS NOT NULL
            ORDER BY r.id;