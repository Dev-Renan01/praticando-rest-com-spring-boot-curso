--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-12-02 22:43:11

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
-- TOC entry 217 (class 1259 OID 16581)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id bigint NOT NULL,
    endereco character varying(80) NOT NULL,
    genero character varying(10) NOT NULL,
    nome character varying(80) NOT NULL,
    sobrenome character varying(80) NOT NULL
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16586)
-- Name: pessoa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pessoa_seq OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16587)
-- Name: pessoadto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoadto (
    id bigint NOT NULL,
    endereco character varying(80) NOT NULL,
    genero character varying(10) NOT NULL,
    nome character varying(80) NOT NULL,
    sobrenome character varying(80) NOT NULL
);


ALTER TABLE public.pessoadto OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16592)
-- Name: pessoadto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoadto_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pessoadto_seq OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16699)
-- Name: pessoadtov2; Type: TABLE; Schema: public; Owner: postgres
--


--
-- TOC entry 222 (class 1259 OID 16704)
-- Name: pessoadtov2_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--


--
-- TOC entry 4856 (class 0 OID 16581)
-- Dependencies: 217
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (id, endereco, genero, nome, sobrenome) FROM stdin;
2	rua dos palmares, muribeca	homem	Thiago	Silva
52	rua das vieiras, muribeca	femea	SUANY	Silva
\.


--
-- TOC entry 4858 (class 0 OID 16587)
-- Dependencies: 219
-- Data for Name: pessoadto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoadto (id, endereco, genero, nome, sobrenome) FROM stdin;
\.


--
-- TOC entry 4860 (class 0 OID 16699)
-- Dependencies: 221
-- Data for Name: pessoadtov2; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4867 (class 0 OID 0)
-- Dependencies: 218
-- Name: pessoa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_seq', 101, true);


--
-- TOC entry 4868 (class 0 OID 0)
-- Dependencies: 220
-- Name: pessoadto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoadto_seq', 1, false);


--
-- TOC entry 4869 (class 0 OID 0)
-- Dependencies: 222
-- Name: pessoadtov2_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoadtov2_seq', 1, false);


--
-- TOC entry 4706 (class 2606 OID 16585)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 4708 (class 2606 OID 16591)
-- Name: pessoadto pessoadto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoadto
    ADD CONSTRAINT pessoadto_pkey PRIMARY KEY (id);


--
