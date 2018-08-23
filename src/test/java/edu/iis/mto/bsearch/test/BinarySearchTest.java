package edu.iis.mto.bsearch.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test
    public void elementFoundInMiddleOfSequenceWhenSequenceSizeGreaterThanOneV1() {
        int key = 5;
        int[] seq = {2, 4, 5, 9, 10, 14};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
        assertThat(result.getPosition(), equalTo(3));
    }

    @Test
    public void elementFoundInMiddleOfSequenceWhenSequenceSizeGreaterThanOneV2() {
        int key = 9;
        int[] seq = {2, 4, 5, 9, 10, 14};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
        assertThat(result.getPosition(), equalTo(4));
    }

    @Test
    public void elementFoundInMiddleOfSequenceWhenSequenceSizeGreaterThanOneV3() {
        int key = 9;
        int[] seq = {2, 4, 5, 9, 10, 14, 21};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(true));
        assertThat(result.getPosition(), equalTo(4));
    }

    @Test
    public void elementNotFoundInSequenceWhenSequenceSizeGreaterThanOne() {
        int key = 3;
        int[] seq = {2, 4, 5, 9, 10, 14, 21};
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), equalTo(false));
    }

    @Test
    public void throwExceptionWhenSequenceSizeIsEqualToZero() {
        int key = 5;
        int[] seq = {};
        try {
            BinarySearch.search(key, seq);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo("Sequence size must be greater than zero"));
        }
    }

    @Test
    public void throwExceptionWhenSequenceIsNotInOrder() {
        int key = 5;
        int[] seq = {4, 25, 12, 21, 53, 58};
        try {
            BinarySearch.search(key, seq);
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo("Sequence must be in ascending order"));

        }
    }
}
