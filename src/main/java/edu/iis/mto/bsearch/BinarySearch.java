/**
 * 
 */
package edu.iis.mto.bsearch;

/**
 * Utility Class dla wyszukiwania binarnego
 * 
 */
public class BinarySearch {

    /**
     * Metoda realizujaca wyszukiwanie binarne
     * 
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) throws IllegalArgumentException {
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();
        if (seq.length == 0) {
            throw new IllegalArgumentException("Sequence size must be greater than zero");
        }
        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center + 1);
                break;
            } else {
                if (seq[center] < key)
                    start = center + 1;
                else
                    end = center - 1;
            }

        }
        return result;
    }

}
