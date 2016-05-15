package pe.cibertec.demo02.dao;

import android.database.Cursor;

import java.util.ArrayList;

import pe.cibertec.demo02.entities.Persona;

/**
 * Created by Android-SAB-PM on 14/05/2016.
 */
public class PersonaDAO {

    public ArrayList<Persona> listPersonas(String nombreGenero) {
        Cursor cursor = null;
        ArrayList<Persona> lstPersona = new ArrayList<>();
        try {
            cursor = DataBaseSingleton.getInstance().rawQuery("select p.*,g.nombre GeneroNombre from Persona p join Genero g on p.idgenero=g.idgenero where g.nombre like ?", new String[]{"%" + nombreGenero + "%"});

            if (cursor.moveToFirst()) {
                do {
                    lstPersona.add(transformCursorToPersona(cursor));
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }

        return lstPersona;
    }

    private Persona transformCursorToPersona(Cursor cursor) {
        Persona persona = new Persona();

        persona.setIdpersona(cursor.isNull(cursor.getColumnIndex("idpersona")) ? 0 : cursor.getInt(cursor.getColumnIndex("idpersona")));

        persona.setNombre(cursor.isNull(cursor.getColumnIndex("nombre")) ? "" : cursor.getString(cursor.getColumnIndex("nombre")));

        persona.setApellido(cursor.isNull(cursor.getColumnIndex("apellido")) ? "" : cursor.getString(cursor.getColumnIndex("apellido")));

        persona.setDni(cursor.isNull(cursor.getColumnIndex("dni")) ? "" : cursor.getString(cursor.getColumnIndex("dni")));

        persona.setEdad(cursor.isNull(cursor.getColumnIndex("edad")) ? 0 : cursor.getInt(cursor.getColumnIndex("edad")));

        persona.setGeneroNombre(cursor.isNull(cursor.getColumnIndex("GeneroNombre")) ? "-" : cursor.getString(cursor.getColumnIndex("GeneroNombre")));

        return persona;
    }
}
