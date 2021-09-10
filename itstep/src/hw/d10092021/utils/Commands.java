package hw.d10092021.utils;

import hw.d10092021.sql.enums.DB;
import hw.d10092021.sql.enums.SQLite;
import hw.d10092021.sql.types.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;

public class Commands implements Command {
    private Class _cl = null;
    private DB _db = null;
    private Annotation[] _ano = null;
    private Field[] _fields = null;
    StringBuilder _table = null;
    StringBuilder _rows = null;
    StringBuilder _colm = null;
    StringBuilder _values = null;
    StringBuilder _cmd = null;

    @Override
    public String create(Object db, Object enm, Object mdl) {
        _cmd = new StringBuilder();
        try {
            _cl = db.getClass();
            if (_cl.getTypeName().equals(DB.class.getTypeName())) {
                _db = (DB) db;
                _cl = mdl.getClass();
                _table = new StringBuilder();
                _ano = _cl.getAnnotations();
                for (int i = 0; i < _ano.length; i++) {
                    if (_ano[i] instanceof Table) {
                        Table t = (Table) _ano[i];
                        _table.append(t.name().toUpperCase(Locale.ROOT));
                    }
                }

                switch (_db) {
                    case SQLITE -> {
                        _cl = enm.getClass();
                        if (_cl.getTypeName().equals(SQLite.class.getTypeName())) {
                            SQLite _enm = (SQLite) enm;
                            switch (_enm) {
                                case TABLE -> {
                                    _cmd.append(SQLite.CREATE.getValue());
                                    _cmd.append(SQLite.TABLE.getValue());
                                    _cmd.append(SQLite.IF.getValue());
                                    _cmd.append(SQLite.NOT.getValue());
                                    _cmd.append(SQLite.EXISTS.getValue());
                                    _cmd.append(_table);
                                    _cmd.append(" ");
                                    _cmd.append(getSQLiteRows(mdl));
                                }
                                case RECORD -> {
                                    _cmd.append(SQLite.INSERT_INTO.getValue());
                                    _cmd.append(_table);
                                    _cmd.append(" ");
                                    _cmd.append(getSQLiteRowsWithValues(mdl));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return _cmd.toString();
    }

    @Override
    public String read(Object db, Object enm, Object mdl) {
        _cmd = new StringBuilder();
        try {
            _cl = db.getClass();
            if (_cl.getTypeName().equals(DB.class.getTypeName())) {
                _db = (DB) db;
                _cl = mdl.getClass();
                _table = new StringBuilder();
                _ano = _cl.getAnnotations();
                for (int i = 0; i < _ano.length; i++) {
                    if (_ano[i] instanceof Table) {
                        Table t = (Table) _ano[i];
                        _table.append(t.name().toUpperCase(Locale.ROOT));
                    }
                }

                switch (_db) {
                    case SQLITE -> {
                        _cl = enm.getClass();
                        if (_cl.getTypeName().equals(SQLite.class.getTypeName())) {
                            SQLite _enm = (SQLite) enm;
                            switch (_enm) {
                                case TABLE -> {
                                    _cmd.append(SQLite.SELECT.getValue() + " * ");
                                    _cmd.append(SQLite.FROM.getValue());
                                    _cmd.append(_table);
                                    //_cmd.append(";");
                                }
                                case RECORD -> {
                                    _cmd.append(getSQLiteRowsRelations(mdl));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return _cmd.toString();
    }

    @Override
    public String update(Object db, Object enm, Object mdl) {
        _cmd = new StringBuilder();
        try {
            _cl = db.getClass();
            if (_cl.getTypeName().equals(DB.class.getTypeName())) {
                _db = (DB) db;
                _cl = mdl.getClass();
                _table = new StringBuilder();
                _ano = _cl.getAnnotations();
                for (int i = 0; i < _ano.length; i++) {
                    if (_ano[i] instanceof Table) {
                        Table t = (Table) _ano[i];
                        _table.append(t.name().toUpperCase(Locale.ROOT));
                    }
                }

                switch (_db) {
                    case SQLITE -> {
                        _cl = enm.getClass();
                        if (_cl.getTypeName().equals(SQLite.class.getTypeName())) {
                            SQLite _enm = (SQLite) enm;
                            switch (_enm) {
                                case TABLE -> {
                                    // for homework not necessary
                                }
                                case RECORD -> {
                                    _cmd.append(SQLite.UPDATE.getValue());
                                    _cmd.append(_table);
                                    _cmd.append(" ");
                                    _cmd.append(SQLite.SET.getValue());
                                    _cmd.append(getSQLiteSetRows(mdl));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return _cmd.toString();
    }
    @Override
    public String delete(Object db, Object enm, Object mdl) {
        _cmd = new StringBuilder();
        try {
            _cl = db.getClass();
            if (_cl.getTypeName().equals(DB.class.getTypeName())) {
                _db = (DB) db;
                _cl = mdl.getClass();
                _table = new StringBuilder();
                _ano = _cl.getAnnotations();
                for (int i = 0; i < _ano.length; i++) {
                    if (_ano[i] instanceof Table) {
                        Table t = (Table) _ano[i];
                        _table.append(t.name().toUpperCase(Locale.ROOT));
                    }
                }

                switch (_db) {
                    case SQLITE -> {
                        _cl = enm.getClass();
                        if (_cl.getTypeName().equals(SQLite.class.getTypeName())) {
                            SQLite _enm = (SQLite) enm;
                            switch (_enm) {
                                case TABLE -> {
                                    _cmd.append(SQLite.DROP.getValue());
                                    _cmd.append(SQLite.TABLE.getValue());
                                    _cmd.append(_table);
                                    _cmd.append(";");
                                }
                                case RECORD -> {
                                    _cmd.append(SQLite.DELETE.getValue());
                                    _cmd.append(SQLite.FROM.getValue());
                                    _cmd.append(_table);
                                    _cmd.append(" ");
                                    _cmd.append(SQLite.WHERE.getValue());
                                    _cmd.append(SQLite.ID.getValue());
                                    _cmd.append("= ?;");
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return _cmd.toString();
    }
    private String getSQLiteRows(Object mdl) {
        _cl = mdl.getClass();
        _rows = new StringBuilder("( ");
        _fields = _cl.getDeclaredFields();

        for (Field field : _fields) {
            _ano = field.getAnnotations();
            _rows.append(field.getName().toUpperCase(Locale.ROOT));
            _rows.append(" ");
            int i = 0;
            for (; i < _ano.length; i++) {
                if (_ano[i] instanceof SQLInteger) {
                    SQLInteger t = (SQLInteger) _ano[i];
                    _rows.append(t.name().toUpperCase(Locale.ROOT));
                    _rows.append(" ");
                }

                if (_ano[i] instanceof SQLString) {
                    SQLString t = (SQLString) _ano[i];
                    _rows.append(t.name().toUpperCase(Locale.ROOT));
                    _rows.append(" ");
                }

                if (_ano[i] instanceof PrimaryKey) {
                    PrimaryKey t = (PrimaryKey) _ano[i];
                    _rows.append(SQLite.PRIMARY_KEY.getValue());
                    if (t.autoincrement()) {
                        _rows.append(SQLite.AUTOINCREMENT.getValue());
                    }
                }

                if (_ano[i] instanceof Constrains) {
                    Constrains t = (Constrains) _ano[i];
                    if (!t.allowNull()) {
                        _rows.append(SQLite.NOT_NULL.getValue());
                    }
                    if (t.unique()) {
                        _rows.append(SQLite.UNIQUE.getValue());
                    }
                }

            }
            _rows.append(", ");
        }
        _rows.delete(_rows.length() - 3, _rows.length() - 1);

        _rows.append(");");

        return _rows.toString();
    }
    private String getSQLiteRowsWithValues(Object mdl) {
        _cl = mdl.getClass();
        _colm = new StringBuilder("( ");
        _values = new StringBuilder("( ");
        _fields = _cl.getDeclaredFields();


        for (int i = 0; i < _fields.length; i++) {
            _ano = _fields[i].getAnnotations();
            PrimaryKey pk = null;
            try {
                pk = (PrimaryKey) Arrays.stream(_fields[i].getAnnotations()).filter(x -> x.annotationType().equals(PrimaryKey.class)).findFirst().get();
            } catch (Exception e) {
                // nothing because throw exc -> is not annotations present
            }
            if (pk != null && pk.autoincrement()) continue;

            _colm.append(_fields[i].getName().toUpperCase(Locale.ROOT));
            _values.append("?");
            if (i < _fields.length - 1) {
                _colm.append(", ");
                _values.append(",");
            }
        }

        _colm.append(" ) " + SQLite.VALUES);
        _values.append(" );");
        _colm.append(_values);
        return _colm.toString();
    }

    private String getSQLiteSetRows(Object mdl) {
        _cl = mdl.getClass();
        _colm = new StringBuilder(" ");
        _fields = _cl.getDeclaredFields();

        for (int i = 0; i < _fields.length; i++) {
            _ano = _fields[i].getAnnotations();
            _colm.append(_fields[i].getName().toUpperCase(Locale.ROOT));
            int c = Arrays.stream(_fields[i].getAnnotations()).filter(x -> x instanceof SQLString).toArray().length;
            if (c == 0) {
                _colm.append(" = ?");
            } else {
                _colm.append(" = '?'");
            }
            if (i < _fields.length - 1) {
                _colm.append(", ");
            }
        }

        _colm.append(" " + SQLite.WHERE.getValue());
        _colm.append(SQLite.ID.getValue() + "= ?;");
        return _colm.toString();
    }
    private String getSQLiteRowsRelations(Object mdl) throws IllegalAccessException {
        _cl = mdl.getClass();
        _fields = _cl.getDeclaredFields();
        _colm = new StringBuilder(SQLite.SELECT.getValue() + " * ");
        _colm = new StringBuilder(SQLite.FROM.getValue());
        for (int i = 0; i < _fields.length; i++) {
            _ano = _fields[i].getAnnotations();
            for (int j = 0; j < _ano.length; j++) {
                if(_ano[j] instanceof ForeignKey){
                    ForeignKey fk = (ForeignKey) _ano[j];
                    _colm.append(fk.innerColumn().toUpperCase(Locale.ROOT));
                    _colm.append(" " + SQLite.WHERE.getValue());
                    _colm.append(fk.outerColumn().toUpperCase(Locale.ROOT) + " = ");
                    _ano = _fields[i].getAnnotations();
                    for (int w = 0; w < _ano.length; w++) {
                        if(_ano[w] instanceof SQLInteger){
                            _colm.append(_fields[i].getLong(_fields[i])); // &&&
                            break;
                        }
                    }
                    i = _fields.length;
                    break;
                }
            }
        }
        _colm.append(";");
        return _colm.toString();
    }
}
