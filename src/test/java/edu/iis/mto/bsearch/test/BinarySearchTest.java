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

    @Test
    public void elementFoundInFirstPlaceInSequenceWhenSequenceSizeGreaterThanOne() {
        int key = 2;
        int[] seq = {2, 4, 5, 9, 10, 14};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
        assertThat(result.getPosition(), equalTo(1));
    }

    @Test
    public void elementFoundInLastPlaceInSequenceWhenSequenceSizeGreaterThanOne() {
        int key = 14;
        int[] seq = {2, 4, 5, 9, 10, 14};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
        assertThat(result.getPosition(), equalTo(seq.length));
    }

}
