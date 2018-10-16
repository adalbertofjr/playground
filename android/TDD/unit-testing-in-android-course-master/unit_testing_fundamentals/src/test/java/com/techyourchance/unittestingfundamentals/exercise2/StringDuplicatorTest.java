package com.techyourchance.unittestingfundamentals.exercise2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class StringDuplicatorTest {


    private StringDuplicator SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new StringDuplicator();
    }

    @Test
    public void duplicate_empty_emptyStringReturned() throws Exception  {
        String result = SUT.duplicate("");

        Assert.assertThat(result, is(""));
    }

    @Test
    public void duplicate_blankString_blankStringDuplicateReturned() throws Exception {
        String result = SUT.duplicate(" ");

        Assert.assertThat(result, is("  "));
    }

    @Test
    public void duplicate_longString_longStringReturned() throws Exception  {
        String result = SUT.duplicate("ovo");

        Assert.assertThat(result, is("ovoovo"));
    }

    @Test
    public void duplicate_singleCharacter_singleCharacerReturned() throws Exception {
        String result = SUT.duplicate("a");

        Assert.assertThat(result, is("aa"));
    }
}