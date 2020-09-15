package jebm.sipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
	//Creación de tablas de la base de datos
    public static final String CONFIG = "CREATE TABLE Configura (Usuario text PRIMARY KEY, nombre text not null, Clave text not null, TiempoEspera text not null, Servicio text not null);";
    public static final String ARTICU = "CREATE TABLE Articulos (Codigo text PRIMARY KEY, Id_Linea text, Descripcion text, PorcIVA real,PorcRteFte real,Stock real,UnidadesxCaja text, Marca text,Medida text,Valor real);";
    public static final String CLIENT = "CREATE TABLE Clientes  (TipoDocu text NOT NULL, Identificacion text NOT NULL, Nombre1 text, Nombre2 text, Apellido1 text, Apellido2 text, RSocial text, PRIMARY KEY (TipoDocu, Identificacion));";
    public static final String SUCURX = "CREATE TABLE Sucursal (Codigo text NOT NULL, IdCliente text NOT NULL, Nombre NOT NULL, Direccion text, TelFijo text, TelMovil text, Email text, Observacion text, IdRuta text, Cupo real NOT NULL,IdPais Text, IdDpto Text, IdCiudad text, PRIMARY KEY(Codigo, IdCliente));";
    public static final String COBRAN = "CREATE TABLE Cobranzas (Numero text NOT NULL PRIMARY KEY UNIQUE, Id_Sucursal text,IdCliente text,Fecha date,Id_Factura text,Total real,Observaciones text,Hora text);";
    public static final String TIPDOC = "CREATE TABLE TipoDocu (Codigo text NOT NULL PRIMARY KEY UNIQUE, Descripcion text NOT NULL);";
    public static final String LINEAX = "CREATE TABLE Linea (Codigo text NOT NULL PRIMARY KEY UNIQUE, Descripcion text NOT NULL);";
    public static final String RUTAXX = "CREATE TABLE Ruta (Codigo text NOT NULL PRIMARY KEY UNIQUE,  Descripcion text NOT NULL);";
    public static final String PAISXX = "CREATE TABLE Pais ( Codigo text  NOT NULL PRIMARY KEY UNIQUE,Nombre text not null);";
    public static final String DEPETO = "CREATE TABLE Departamento ( Codigo text, CodPais text not null, Nombre text not null, primary key(Codigo, CodPais));";
    public static final String MUNPIO = "CREATE TABLE Municipio ( Codigo text not null,CodPais text not null, CodDpto not null, Nombre text not null, primary key(Codigo, CodPais, CodDpto));";
    public static final String ENCDOC = "CREATE TABLE EncabezDoc ( Numerodocu numeric primary key, IdCliente text not null, ValorBruto float not null, Total float not null);";
    public static final String DETDOC = "CREATE TABLE DetalleDoc ( NumeroDocu numeric not null, Item numeric not null, CodProducto text not null, InidMedida text not null, Cantidad float not null, ValorUnit float not null, VlrTotal float not null,primary key(NumeroDocu, Item) );";

    public static final String INSCON = "INSERT INTO Configura VALUES('Admin', 'Administrador','123', 5, 'prueba');";

    public static final String INSTD1 = "INSERT INTO TipoDocu VALUES('CC', 'Cédula de Ciudadanía');";
    public static final String INSTD2 = "INSERT INTO TipoDocu VALUES('TI', 'Tarjeta de Identidad');";

    public static final String INSTD3 = "INSERT INTO Linea VALUES('001', 'Kimberly');";
    public static final String INSTD4 = "INSERT INTO Linea VALUES('002', 'Detergente');";
    public static final String INSTD5 = "INSERT INTO Linea VALUES('003', 'Alpina');";

    public static final String INSRU1 = "INSERT INTO Ruta VALUES('001', 'Barranca Centro');";
    public static final String INSRU2 = "INSERT INTO Ruta VALUES('002', 'Oriente');";

    public static final String MUNIC1 = "INSERT INTO municipio values('001','57','05','Medellin');";
    public static final String MUNIC2 = "INSERT INTO municipio values('081','57','68','Barranca');";

    public static final String ARTI01 = "INSERT INTO Articulos values('0001','001','Papel aluminio', 16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI02 = "INSERT INTO Articulos values('0002','001','Papel boon', 16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI03 = "insert into Articulos values('0003','001','Papel cartulina',16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI04 = "insert into Articulos values('0004','001','Papel tamaño carta', 16, 3, 50, 12,'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI05 = "insert into Articulos values('0005','001','Papel Calcante', 16, 3, 50, 12,'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI06 = "insert into Articulos values('0006','001','Cinta adhesiva',16, 3, 50, 12,'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI07 = "insert into Articulos values('0007','002','Detergente X kilo', 16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI08 = "insert into Articulos values('0008','002','Jabon en barra', 16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI09 = "insert into Articulos values('0009','003','Compota baby',  16, 3, 50, 12,  'ALUMINA','UNIDAD', 50000);";
    public static final String ARTI10 = "insert into Articulos values('0010','003','Lecherita tarro', 16, 3, 50, 12, 'ALUMINA','UNIDAD', 50000);";

    public static final String CLIE01 = "insert into Clientes values ('CC', '7924785', 'Joaquín', 'Ernesto', 'Bermúdez', 'Medina', 'Joaquín Ernesto Bermúdez Medina');";
    public static final String CLIE02 = "Insert into Clientes values ('CC', '79247851', 'Joaquín', 'Ernesto', 'Bermúdez', 'Medina', 'Joaquín Ernesto Bermúdez Medina');";
    public static final String CLIE03 = "insert into Clientes values ('CC', '79247852', 'Joaquín', 'Ernesto', 'Bermúdez', 'Medina', 'Joaquín Ernesto Bermúdez Medina');";
    public static final String CLIE04 = "insert into Clientes values ('CC', '79247853', 'Joaquín', 'Ernesto', 'Bermúdez', 'Medina', 'Joaquín Ernesto Bermúdez Medina');";
    public static final String CLIE05 = "insert into Clientes values ('CC', '79247854', 'Joaquín', 'Ernesto', 'Bermúdez', 'Medina', 'Joaquín Ernesto Bermúdez Medina');";

    //Codigo, IdCliente, Nombre, Direccion, TelFijo, TelMovil, Email, Observacion, IdRuta, Cupo ,IdPais, IdDpto, IdCiudad

    public static final String SUCU01 = "Insert into Sucursal values ('1', '7924785',  'Principal',   'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '001', 5000000,'57','05', '001');";
    public static final String SUCU02 = "Insert into Sucursal values ('2', '79247851', 'Principal 1', 'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '001', 5000000,'57','05', '001');";
    public static final String SUCU03 = "Insert into Sucursal values ('3', '79247852', 'Principal 1', 'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '002', 5000000,'57','05', '001');";
    public static final String SUCU04 = "Insert into Sucursal values ('4', '79247853', 'Principal 1', 'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '002', 5000000,'57','05', '001');";
    public static final String SUCU05 = "Insert into Sucursal values ('5', '79247854', 'Principal 1', 'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '002', 5000000,'57','05', '001');";
    public static final String SUCU06 = "Insert into Sucursal values ('6', '7924785',  'Centro',      'Calle 94 #49A-17 Apto 407', '5844212', '3128823506', 'jobeme@gmail.com', '', '001', 5000000,'57','05', '001');";

    private DBHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {

        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public Cursor ObtenerRuta(){
        String[] columnas = new String[]{"Codigo", "Descripcion"};
        return db.query("Ruta", columnas, null, null, null, null, null);
    }

    public Cursor Obtenerciudad() {
        String[] columnas = new String[]{"CodPais", "CodDpto", "Codigo", "Nombre"};
        return db.query("Municipio", columnas, null, null, null, null, null);
    }
    public Cursor ObtenerDpto() {
        String[] columnas = new String[]{"CodPais", "Codigo", "Nombre"};
        return db.query("Departamento", columnas, null, null, null, null, null);
    }

    public Cursor ObtenerPais() {
        String[] columnas = new String[]{"Codigo", "Nombre"};
        return db.query("Pais", columnas, null, null, null, null, null);
    }

    public Cursor ObtenerTipodocu() {
        String[] columnas = new String[]{"Codigo", "Valor1"};
        return db.query("ConcValor", columnas, "CodConc = '01'", null, null, null, null);
    }

    public Cursor ObtenerClientes(String pIdruta){
        String sSQL;
        sSQL = "select a.TipoDocu, a.Identificacion, a.Nombre1, a.Nombre2, a.Apellido1, a.Apellido2, a.RSocial, ";
        sSQL = sSQL + "b.Codigo, b.IdCliente, b.Nombre, b.Direccion, b.TelFijo, b.TelMovil, b.Email, b.Observacion, ";
        sSQL = sSQL + "b.IdRuta, b.Cupo, b.IdPais, b.IdDpto, b.IdCiudad ";
        sSQL = sSQL + "from Clientes a, Sucursal b ";
        sSQL = sSQL + "where a.Identificacion = b.IdCliente";
        if (pIdruta != "")
            sSQL = sSQL + " and b.IdRuta = '" + pIdruta  + "';";
        return db.rawQuery(sSQL,null);
    }

    public void crearcliente(String pSQL){
        db.execSQL(pSQL);
    }

    public Cursor ObtenerCliente(String parametro) {
        String[] columnas = new String[]{"codigo||';'|| nombre1||' '||nombre2||' '||apellido1||' '||Apellido2 Item1, Direccion||';'||telefono||';'||idpais||';'||iddpto||';'||idmpio as item2"};
        if (parametro!="")
            return db.query("cliente", columnas, "codigo like ? or nombre1 like ? or apellido1 like ?", new String[]{"%"+parametro+"%", "%"+parametro+"%","%"+parametro+"%"},null, null, "nombre1");
        else
            return db.query("cliente", columnas, null, null, null,null, "nombre1");
    }

    public Cursor verificarCliente(String parametro) {
        String sSQL = "select count(2) from cliente where codigo = '"+parametro+"'";
        return db.rawQuery(sSQL,null);
    }

    public Cursor ObtenerProducto(String parametro) {
        String[] columnas = new String[]{"a.codigo||';'||a.codlinea||';'||a.nombre||';'||b.nombre item1,a.unidmedida||';'||a.stock||';'||a.valor item2"};
        if (parametro!="")
            return db.query("producto a, linea b", columnas, " a.codlinea = b.codigo and (a.codigo like ? or a.CodLinea like ? or a.nombre like ? or b.nombre like ?)", new String[]{"%"+parametro+"%", "%"+parametro+"%","%"+parametro+"%"},null, null, "a.nombre, b.nombre");
        else
            return db.query("producto a, linea b", columnas, "a.codlinea = b.codigo", null, null,null, "a.nombre, b.nombre");
    }

    public Cursor Obtenerconfiguracion(String pusr, String ppwr) {
        String[] columnas = new String[]{"nombre, TiempoEspera, Servicio"};
        return db.query("Configura", columnas, " Usuario=? and Clave=?", new String[]{pusr, ppwr},null, null, null);

    }
}
