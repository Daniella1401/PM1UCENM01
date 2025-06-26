package com.example.pm1ucenm01.configuraciones;

public class Transacciones
{
    //Nombre de la base de datos
    public static final String NameDB = "MOVIL1";

    // Tablas de la base de datos
    public static final String tablaPersonas = "personas";

    //  Campos de la tabla
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String correo = "correo";
    public static final String telefono = "telefono";

    //DDL CREATE
    public static final String CreateTablePersonas = "CREATE TABLE " + tablaPersonas + "( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            nombres + " TEXT, "+
            apellidos + " TEXT, "+
            correo + " TEXT, "+
            telefono + " TEXT )";

    // DDL DROP
    public static final String DROPTablePersonas = "DROP TABLE IF EXISTS " + tablaPersonas;

    // DML SELECT
    public static final String SelectPersonas = "SELECT * FROM " + tablaPersonas;
}
