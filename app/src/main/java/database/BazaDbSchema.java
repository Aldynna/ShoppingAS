package database;

/**
 * Created by korisnik on 27.06.2017..
 */

public class BazaDbSchema {
    public static final class KorisnikTable {
        public static final String NAME = "korisnici";

        public static final class Cols {
            public static final String KORISNIKID = "id";
            public static final String USERNAME = "user";
            public static final String DATUM = "datum";
        }
    }

}
