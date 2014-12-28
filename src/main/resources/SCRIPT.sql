SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `b13` ;
CREATE SCHEMA IF NOT EXISTS `b13` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `b13` ;

-- -----------------------------------------------------
-- TABLE USUARIO DEL SISTEMA
-- -----------------------------------------------------
DROP TABLE IF EXISTS USUARIO ;
CREATE  TABLE IF NOT EXISTS USUARIO (
  CO_USUARIO   CHAR(08)    NOT NULL ,
  DE_LOGIN     VARCHAR(45) NULL,
  DE_PASSWORD  VARCHAR(45) NULL,
  FE_REGISTRA  DATETIME    NULL,
  CO_ESTADO    CHAR(02)    NULL,
  PRIMARY KEY (CO_USUARIO) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- TABLE CLIENTE
-- -----------------------------------------------------
DROP TABLE IF EXISTS CLIENTE ;
CREATE  TABLE IF NOT EXISTS CLIENTE (
  CO_CLIENTE            CHAR(8)      NOT NULL ,
  DE_NOMBRE             VARCHAR(45)  NULL,
  DE_APELLIDO_PATERNO   VARCHAR(150) NULL,
  DE_APELLIDO_MATERNO   VARCHAR(150) NULL,
  FE_REGISTRA           DATETIME     NULL,
  CO_ESTADO             CHAR(02)     NULL,
  CO_USUARIO            CHAR(8)      NOT NULL,
  PRIMARY KEY (CO_CLIENTE) ,
  CONSTRAINT CONS_USUARIO FOREIGN KEY (CO_USUARIO) REFERENCES USUARIO (CO_USUARIO)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- TABLE ARTICULO
-- -----------------------------------------------------
DROP TABLE IF EXISTS ARTICULO ;
CREATE  TABLE IF NOT EXISTS ARTICULO (
  CO_ARTICULO    CHAR(8)      NOT NULL ,
  NO_ARTICULO    VARCHAR(100) NULL,
  DE_MARCA       VARCHAR(150) NULL,
  PRECIO_VENTA   DOUBLE       NULL,
  FE_REGISTRA    DATETIME     NULL,
  CO_ESTADO      CHAR(02)     NULL,
  PRIMARY KEY (CO_ARTICULO)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


DROP TABLE IF EXISTS RECIBO ;
CREATE  TABLE IF NOT EXISTS RECIBO(
  CO_RECIBO 	  CHAR(15)     NOT NULL,
  CO_CLIENTE      VARCHAR(8)   NOT NULL,
  NU_COMPROBANTE  VARCHAR(20)  NULL,
  FE_REGISTRO     DATETIME     NULL,
  SUBTOTAL        DOUBLE       NULL,
  IGV             DOUBLE       NULL,
  TOTAL           DOUBLE       NULL,
  CO_OPERACION    CHAR(2)      NULL,
  CO_ESTADO       CHAR(2)      NULL,
  PRIMARY KEY (CO_RECIBO),
  CONSTRAINT CONS_RECIBO FOREIGN KEY (CO_CLIENTE) REFERENCES CLIENTE (CO_CLIENTE)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS DETRECIBO ;
CREATE  TABLE IF NOT EXISTS DETRECIBO(
  CO_DET_RECIBO	  CHAR(15)     NOT NULL,
  CO_RECIBO       CHAR(15)     NOT NULL,
  DE_DESCRIPCION  VARCHAR(120) NOT NULL,
  CANTIDAD        DOUBLE,
  PRECIO_UNITARIO DOUBLE,
  IMPORTE         DOUBLE,
  CO_ESTADO       CHAR(2)      NULL,
  PRIMARY KEY (CO_DET_RECIBO),
  CONSTRAINT CONS_DET_RECIBO FOREIGN KEY (CO_RECIBO) REFERENCES RECIBO (CO_RECIBO)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



DROP TABLE IF EXISTS ESTADO;
CREATE TABLE ESTADO (
   CO_ESTADO  CHAR(2)     NOT NULL,
   NO_ESTADO  VARCHAR(20) NULL,
  PRIMARY KEY (CO_ESTADO)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO ESTADO VALUES
('01','HABILITADO'),
('02','INHABILITADO');


DROP TABLE IF EXISTS OPERACION;
CREATE TABLE OPERACION (
   CO_OPERACION  CHAR(2)     NOT NULL,
   NO_OPERACION  VARCHAR(20) null,
  PRIMARY KEY (CO_OPERACION)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO OPERACION VALUES
('01','INGRESO'),
('02','EGRESO');

DROP TABLE IF EXISTS MONEDA;
CREATE TABLE MONEDA (
   CO_MONEDA  CHAR(2)     NOT NULL,
   NO_MONEDA  VARCHAR(20) null,
   NU_TIPOCAMBIO DOUBLE,
  PRIMARY KEY (CO_MONEDA)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO MONEDA VALUES
('01','NUEVOS SOLES',1),
('02','DOLARES AMERICANOS',2.5);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO (
   CO_DEPARTAMENTO      char(2)       not null,
   NO_DEPARTAMENTO      varchar(255) null,
   PRIMARY KEY (CO_DEPARTAMENTO)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA (
   CO_PROVINCIA         char(2)          not null,
   CO_DEPARTAMENTO      char(2)          not null,
   NO_PROVINCIA         varchar(255)    null,
   PRIMARY KEY (CO_PROVINCIA, CO_DEPARTAMENTO)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
/*==============================================================*/
/* Table: DISTRITO                                              */
/*==============================================================*/
create table DISTRITO (
   CO_DISTRITO          char(2)         not null,
   CO_PROVINCIA         char(2)         not null,
   CO_DEPARTAMENTO      char(2)         not null,
   NO_DISTRITO          varchar(255)    null,
   PRIMARY KEY (CO_DISTRITO, CO_PROVINCIA, CO_DEPARTAMENTO)
)

