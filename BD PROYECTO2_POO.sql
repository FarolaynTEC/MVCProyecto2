--Creación de la base de dato Proyecto_POO2
CREATE DATABASE Proyecto_POO2
--Se coloca en la base de datos Proyecto_POO2 para hacerle modificaciones
USE Proyecto_POO2

CREATE TABLE TiposCentrosAtencion(
  tipoDeCentro varchar(90) NOT NULL,
  PRIMARY KEY (tipoDeCentro),
);

CREATE TABLE AreaTrabajo(
  AreaTrabajo varchar(80) NOT NULL,
  PRIMARY KEY (AreaTrabajo),
);

CREATE TABLE CentroAtencion(
  codigoCentroAtencion int NOT NULL,
  nombre varchar(70) NOT NULL,
  ubicacion varchar(90) NOT NULL,
  capacidadMaxPac int NOT NULL,
  tipoDeCentro varchar(90) NOT NULL,
  PRIMARY KEY (codigoCentroAtencion),
  FOREIGN KEY (tipoDeCentro) REFERENCES TiposCentrosAtencion(tipoDeCentro)
);

CREATE TABLE Funcionario(
  cedulaFuncionario int NOT NULL,
  nombreFuncionario varchar(70) NOT NULL,
  fechaVigencia date NOT NULL,
  tipoFuncionario varchar(15) NOT NULL,
  codigoCentroAtencion int NOT NULL,
  areaTrabajo varchar(70) NOT NULL,
  PRIMARY KEY (cedulaFuncionario),
  FOREIGN KEY (codigoCentroAtencion) REFERENCES CentroAtencion(codigoCentroAtencion)
);

CREATE TABLE Enfermero(
  cedulaFuncionario int NOT NULL,
  IndicadorPersonasACargo bit NOT NULL,
  IndicadorExpCapacitacion bit NOT NULL,
  FOREIGN KEY (cedulaFuncionario) REFERENCES Funcionario(cedulaFuncionario)
);

CREATE TABLE Doctor(
  cedulaFuncionario int NOT NULL,
  codigoMedico int NOT NULL,
  especialidad varchar NOT NULL,
  FOREIGN KEY (cedulaFuncionario) REFERENCES Funcionario(cedulaFuncionario)
);

CREATE TABLE Citas(
  identificador int NOT NULL,
  fechaCita date NOT NULL,
  observaciones varchar(80) NOT NULL,
  diagnostico varchar(80) NOT NULL,
  estadoDeCita varchar(30) NOT NULL,
  PRIMARY KEY (identificador),
);

CREATE TABLE Diagnostico(
  identificador int NOT NULL,
  nombreDiagnostico varchar(80) NOT NULL,
  observaciones varchar(80) NOT NULL,
  nivel varchar(15) NOT NULL,
  PRIMARY KEY (nombreDiagnostico),
  FOREIGN KEY (identificador) REFERENCES Citas(identificador)
);

CREATE TABLE Tratamiento(
  identificador int NOT NULL,
  nombreTratameinto varchar(80) NOT NULL,
  dosis varchar(80) NOT NULL,
  tipoTratamiento varchar(80) NOT NULL,
  PRIMARY KEY (nombreTratameinto),
  FOREIGN KEY (identificador) REFERENCES Citas(identificador)
);

CREATE TABLE Bitacora(
  idBitacora int NOT NULL,
  identificadorCita int NOT NULL,
  fecha date NOT NULL,
  hora varchar(80) NOT NULL,
  nombreAutor varchar(80) NOT NULL,
  PRIMARY KEY (idBitacora),
  FOREIGN KEY (identificadorCita) REFERENCES Citas(identificador)
);

CREATE TABLE Paciente(
  cedulaPaciente int NOT NULL,
  identificadorCita int NOT NULL,
  nombrePaciente varchar(70) NOT NULL,
  fechaNacimiento date NOT NULL,
  tipoSangre varchar(15) NOT NULL,
  nacionalidad varchar(70) NOT NULL,
  lugarRecidincia varchar(70) NOT NULL,
  telefono int NOT NULL,
  correoElectronico varchar(70) NOT NULL
  PRIMARY KEY (cedulaPaciente),
  FOREIGN KEY (identificadorCita) REFERENCES Citas(identificador)
);

CREATE TABLE Vacuna(
  cedulaPaciente int NOT NULL,
  fechaAplicacion date NOT NULL,
  nombreVacuna varchar(70) NOT NULL,
  farmaceutica varchar(70) NOT NULL,
  numLote varchar(20) NOT NULL,
  FOREIGN KEY (cedulaPaciente) REFERENCES Paciente(cedulaPaciente)
);

CREATE TABLE Hospitalizacion(
  centroAtencion int NOT NULL,
  cedulaPacienteInternado int NOT NULL,
  nombrePacienteInternado varchar NOT NULL,
  diagnostico varchar(80) NOT NULL,
  fechaInicio date NOT NULL,
  fechaFin date NOT NULL,
  especialidadHospitalizacion varchar(80) NOT NULL,
  funcionarioEncargado int NOT NULL,
  PRIMARY KEY (cedulaPacienteInternado),
  FOREIGN KEY (centroAtencion) REFERENCES CentroAtencion(codigoCentroAtencion),
  FOREIGN KEY (cedulaPacienteInternado) REFERENCES Paciente(cedulaPaciente),
  FOREIGN KEY (diagnostico) REFERENCES Diagnostico(nombreDiagnostico),
  FOREIGN KEY (especialidadHospitalizacion) REFERENCES AreaTrabajo(areaTrabajo),
  FOREIGN KEY (funcionarioEncargado) REFERENCES Funcionario(cedulaFuncionario),
);


CREATE TABLE RegistroDeSeguimiento(
  cedulaPacienteInternado int NOT NULL,
  funcionarioSeguimiento int NOT NULL,
  observacionDeEvolucion int NOT NULL,
  tratameintoAsociado varchar(80) NOT NULL,
  FOREIGN KEY (cedulaPacienteInternado) REFERENCES Hospitalizacion(cedulaPacienteInternado),
  FOREIGN KEY (funcionarioSeguimiento) REFERENCES Funcionario(cedulaFuncionario),
  FOREIGN KEY (tratameintoAsociado) REFERENCES Tratamiento(nombreTratameinto),
);
