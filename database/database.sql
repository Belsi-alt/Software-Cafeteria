--
-- PostgreSQL database dump
--

-- Dumped from database version 17.3
-- Dumped by pg_dump version 17.3

-- Started on 2025-12-18 12:15:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16455)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cedula_cliente numeric NOT NULL,
    nombre_cliente text,
    fecha_nacimiento date,
    genero_cliente text,
    telefono_cliente numeric,
    email_cliente text,
    direccion_cliente text
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16460)
-- Name: detalle_venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalle_venta (
    id_detalle numeric NOT NULL,
    id_producto integer[],
    cantidad integer[]
);


ALTER TABLE public.detalle_venta OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16465)
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleado (
    cedula_empleado numeric NOT NULL,
    nombre_empleado text,
    fecha_nacimiento date,
    genero_empleado text,
    telefono_empleado numeric,
    email_empleado text,
    direccion_empleado text
);


ALTER TABLE public.empleado OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16470)
-- Name: familia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.familia (
    id_familia numeric NOT NULL,
    nombre_familia text,
    descripcion_familia text
);


ALTER TABLE public.familia OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16475)
-- Name: ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente (
    id_ingrediente numeric,
    nombre_ingrediente text,
    descripcion text,
    valor_nutricional text
);


ALTER TABLE public.ingrediente OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16480)
-- Name: notificaciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notificaciones (
    id text,
    descripcion text,
    fecha_noti date,
    hora time with time zone,
    estado text,
    fecha_solucion date,
    hora_solucion time with time zone
);


ALTER TABLE public.notificaciones OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16485)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    id_producto numeric NOT NULL,
    nombre_producto text,
    id_familia_producto text,
    descripcion_producto text,
    precio_producto numeric,
    stock_producto numeric,
    existencia_producto numeric,
    id_ingrediente integer[]
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16490)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    nombre text,
    "contraseña" text
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16495)
-- Name: valor_nutricional; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.valor_nutricional (
    id_valor_nutricional numeric NOT NULL,
    descripcion text
);


ALTER TABLE public.valor_nutricional OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16500)
-- Name: venta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venta (
    id_venta numeric NOT NULL,
    id_detalle text,
    id_cliente text,
    id_empleado text,
    fecha_venta date,
    valor numeric
);


ALTER TABLE public.venta OWNER TO postgres;

--
-- TOC entry 4936 (class 0 OID 16455)
-- Dependencies: 217
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cedula_cliente, nombre_cliente, fecha_nacimiento, genero_cliente, telefono_cliente, email_cliente, direccion_cliente) FROM stdin;
1211	belsi	2025-04-11	Femenino	654654	arroba	mz
\.


--
-- TOC entry 4937 (class 0 OID 16460)
-- Dependencies: 218
-- Data for Name: detalle_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalle_venta (id_detalle, id_producto, cantidad) FROM stdin;
1	{4,1}	{2,2}
6	{4,1}	{2,1}
\.


--
-- TOC entry 4938 (class 0 OID 16465)
-- Dependencies: 219
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleado (cedula_empleado, nombre_empleado, fecha_nacimiento, genero_empleado, telefono_empleado, email_empleado, direccion_empleado) FROM stdin;
1092532883	Kerly Molina Arteaga	2007-08-03	Femenino	3219344716	molinakerly12345	manzana 39 lorte 5 palmeras
\.


--
-- TOC entry 4939 (class 0 OID 16470)
-- Dependencies: 220
-- Data for Name: familia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.familia (id_familia, nombre_familia, descripcion_familia) FROM stdin;
1321	lacteos	leche blanca
2	Azucares	Azucares refinados
\.


--
-- TOC entry 4940 (class 0 OID 16475)
-- Dependencies: 221
-- Data for Name: ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingrediente (id_ingrediente, nombre_ingrediente, descripcion, valor_nutricional) FROM stdin;
1	Leche	Leche deslactosada	Alto en sodio
3	Azucar	Azucar blanca refinada	Alta en glucosa
\.


--
-- TOC entry 4941 (class 0 OID 16480)
-- Dependencies: 222
-- Data for Name: notificaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notificaciones (id, descripcion, fecha_noti, hora, estado, fecha_solucion, hora_solucion) FROM stdin;
NOTIF-850291169975800	Existencia baja para : 'fgh'	2025-05-02	17:25:38.829-05	Inactivo	2025-05-02	17:26:18.858413-05
NOTIF-850291157092200	Existencia baja para : 'pastel'	2025-05-02	17:25:38.817-05	Inactivo	2025-05-02	17:26:48.883306-05
NOTIF-857337026115200	Existencia baja para : 'Arroz con leche'	2025-05-02	19:23:04.686-05	Activo	\N	\N
\.


--
-- TOC entry 4942 (class 0 OID 16485)
-- Dependencies: 223
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id_producto, nombre_producto, id_familia_producto, descripcion_producto, precio_producto, stock_producto, existencia_producto, id_ingrediente) FROM stdin;
4	Arroz con leche	1321-lacteos	Arroz con leche y coco	3000	3	1	{2,56,8}
3	Postre 3 leches	1321-lacteos	Postre 3 leches con arequipe	10000	5	6	{1}
2	Cafe con leche	2-Azucares	Cafe con leche y azucar	2000	5	6	{1,3}
1	pastel	1321-lacteos	grande	5000	2	5	{2,10,56}
\.


--
-- TOC entry 4943 (class 0 OID 16490)
-- Dependencies: 224
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (nombre, "contraseña") FROM stdin;
belsi	123b
kerly	123k
\.


--
-- TOC entry 4944 (class 0 OID 16495)
-- Dependencies: 225
-- Data for Name: valor_nutricional; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.valor_nutricional (id_valor_nutricional, descripcion) FROM stdin;
\.


--
-- TOC entry 4945 (class 0 OID 16500)
-- Dependencies: 226
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venta (id_venta, id_detalle, id_cliente, id_empleado, fecha_venta, valor) FROM stdin;
8	1	1211-belsi	1092532883-Kerly Molina	2025-05-02	16000.0
\.


--
-- TOC entry 4778 (class 2606 OID 16506)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cedula_cliente);


--
-- TOC entry 4780 (class 2606 OID 16508)
-- Name: detalle_venta detalle_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_pkey PRIMARY KEY (id_detalle);


--
-- TOC entry 4782 (class 2606 OID 16510)
-- Name: empleado empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (cedula_empleado);


--
-- TOC entry 4784 (class 2606 OID 16512)
-- Name: familia familia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.familia
    ADD CONSTRAINT familia_pkey PRIMARY KEY (id_familia);


--
-- TOC entry 4786 (class 2606 OID 16514)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);


--
-- TOC entry 4788 (class 2606 OID 16516)
-- Name: valor_nutricional valor_nutricional_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.valor_nutricional
    ADD CONSTRAINT valor_nutricional_pkey PRIMARY KEY (id_valor_nutricional);


--
-- TOC entry 4790 (class 2606 OID 16518)
-- Name: venta venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_pkey PRIMARY KEY (id_venta);


-- Completed on 2025-12-18 12:15:35

--
-- PostgreSQL database dump complete
--

