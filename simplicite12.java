package iut.sae.algo.Algorithmes;

import iut.sae.algo.AlgoException;

public class simplicite12 {

    public static String RLE(String chaine) {
        if (chaine == null || chaine.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder();
        int compteur = 1;
        char premierCaractere = chaine.charAt(0);

        for (int i = 1; i < chaine.length(); i++) {
            if (chaine.charAt(i) == premierCaractere) {
                compteur++;
                if (compteur == 9) {
                    resultat.append(9).append(premierCaractere);
                    compteur = 0;
                }
            } else {
                if (compteur > 0) {
                    resultat.append(compteur).append(premierCaractere);
                }
                premierCaractere = chaine.charAt(i);
                compteur = 1;
            }
        }

        if (compteur > 0) {
            resultat.append(compteur).append(premierCaractere);
        }

        return resultat.toString();
    }

    public static String RLE(String chaine, int iteration) {
        String resultat = chaine;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    public static String unRLE(String in) throws AlgoException {
        // Utiliser StringBuilder pour construire le résultat décompressé
        StringBuilder decode = new StringBuilder();
        // Parcourir la chaîne deux caractères à la fois
        for (int i = 0; i < in.length() - 1; i += 2) {
            // Obtenir le nombre de répétitions (premier caractère)
            int count = Integer.parseInt(String.valueOf(in.charAt(i)));
            // Obtenir le caractère à répéter (deuxième caractère)
            char c = in.charAt(i + 1);
            // Ajouter le caractère au résultat le nombre de fois indiqué par le compteur
            for (int j = 0; j < count; j++)
                decode.append(c);
        }
        return decode + "";
    }

    /**
     * Effectue plusieurs itérations de décompression RLE.
     *
     * @param in La chaîne compressée à décompresser.
     * @param iteration Le nombre d'itérations de décompression à effectuer.
     * @return La chaîne décompressée après les itérations spécifiées.
     * @throws AlgoException Si une erreur se produit durant la décompression.
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        // Initialiser le résultat avec la chaîne d'entrée
        String decode = in;
        // Effectuer la décompression pour le nombre d'itérations spécifié
        for (int i = 0; i < iteration; i++) {
            decode = unRLE(decode);
        }
        return decode;
    }


}
