package edu.iis.mto.bsearch.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

    @Test
    public void elementFoundInSequenceWhenSequenceSizeEqualToOne() {
        int key = 2;
        int[] seq = {2};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
    }

    @Test
    public void elementNotFoundInSequenceWhenSequenceSizeEqualToOne() {
        int key = 3;
        int[] seq = {2};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(false));
    }

}
