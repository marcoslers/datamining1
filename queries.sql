create table estacion (
id_estacion int auto_increment primary key,
clave_estacion varchar(50) not null,
nombre_estacion varchar(50) not null,
alcaldia_municipio varchar(50) not null,
entidad varchar(50) not null);

create table elementos (
id_elemento int auto_increment primary key,
clave varchar(50) not null,
nombre varchar(50) not null,
unidad varchar(50) not null,
significado_unidad varchar(50) not null);

create table mediciones (
id_medicion int auto_increment primary key,
id_estacion int not null,
id_elemento int not null,
medicion float not null,
no_semana int not null,
fecha date);

insert into estacion
(clave_estacion,nombre_estacion,alcaldia_municipio,entidad)
values
('ACO','Acolman','Acolman','Estado de México'),
('AJU','Ajusco','Tlalpan','CDMX'),
('AJM','Ajusco Medio','Tlalpan','CDMX'),
('ATI','Atizapán','Atizapán de Zaragoza','Estado de México'),
('BJU','Benito Juarez','Benito Juárez','CDMX'),
('CAM','Camarones','Azcapotzalco','CDMX'),
('CCA','Centro de Ciencias de la Atmósfera','Coyoacán','CDMX'),
('TEC','Cerro del Tepeyac','Gustavo A. Madero','CDMX'),
('CHO','Chalco','Chalco','Estado de México'),
('COR','CORENA','Xochimilco','CDMX'),
('CUA','Cuajimalpa','Cuajimalpa de Morelos','CDMX'),
('CUT','Cuautitlán','Tepotzotlán','Estado de México'),
('DIC','Diconsa','Tlalpan','CDMX'),
('EAJ','Ecoguardas Ajusco','Tlalpan','CDMX'),
('EDL','Ex Convento Desierto de los Leones','Cuajimalpa de Morelos','CDMX'),
('FAC','FES Acatlán','Naucalpan de Juárez','Estado de México'),
('FAR','FES Aragón','Nezahualcóyotl','Estado de México'),
('GAM','Gustavo A. Madero','Gustavo A. Madero','CDMX'),
('HGM','Hospital General de México','Cuauhtémoc','CDMX'),
('INN','Investigaciones Nucleares','Ocoyoacac','Estado de México'),
('IZT','Iztacalco','Iztacalco','CDMX'),
('LPR','La Presa','Tlalnepantla de Baz','Estado de México'),
('LAA','Laboratorio de Análisis Ambiental','Gustavo A. Madero','CDMX'),
('IBM','Legaria','Miguel Hidalgo','CDMX'),
('LOM','Lomas','Miguel Hidalgo','CDMX'),
('LLA','Los Laureles','Ecatepec de Morelos','Estado de México'),
('MER','Merced','Venustiano Carranza','CDMX'),
('MGH','Miguel Hidalgo','Miguel Hidalgo','CDMX'),
('MPA','Milpa Alta','Milpa Alta','CDMX'),
('MON','Montecillo','Texcoco','Estado de México'),
('MCM','Museo de la Ciudad de México','Cuauhtémoc','CDMX'),
('NEZ','Nezahualcóyotl','Nezahualcóyotl','Estado de México'),
('PED','Pedregal','Álvaro Obregón','CDMX'),
('SAG','San Agustín','Ecatepec de Morelos','Estado de México'),
('SNT','San Nicolás Totolapan','La Magdalena Contreras','CDMX'),
('SFE','Santa Fe','Cuajimalpa de Morelos','CDMX'),
('SAC','Santiago Acahualtepec','Iztapalapa','CDMX'),
('TAH','Tláhuac','Xochimilco','CDMX'),
('TLA','Tlalnepantla','Tlalnepantla de Baz','Estado de México'),
('TLI','Tultitlán','Tultitlán','Estado de México'),
('UIZ','UAM Iztapalapa','Iztapalapa','CDMX'),
('UAX','UAM Xochimilco','Coyoacán','CDMX'),
('VIF','Villa de las Flores','Coacalco de Berriozábal','Estado de México'),
('XAL','Xalostoc','Ecatepec de Morelos','Estado de México');

insert into elementos
(clave,nombre,unidad,significado_unidad)
values
('PP','Precipitación pluvial','mm','milímetros de lluvia');
