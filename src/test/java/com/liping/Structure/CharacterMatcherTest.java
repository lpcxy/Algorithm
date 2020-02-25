package com.liping.Structure;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CharacterMatcherTest {

    @Test
    public void testIndexOf() {
        String t = "good morning, liping";
        String p = "liping";
        assertThat(CharacterMatcher.INSTANCE.indexOf(t, p)).isEqualTo(14);
        assertThat(CharacterMatcher.INSTANCE.indexOf(t, "afeter")).isEqualTo(-1);
    }

    @Test
    public void testMatchStartWithPos() {
        String t = "good morning, liping";
        String p = "liping";
        assertThat(CharacterMatcher.INSTANCE.matchStartWithPos(t, p, 0)).isEqualTo(false);
        assertThat(CharacterMatcher.INSTANCE.matchStartWithPos(t, p, 14)).isEqualTo(true);
    }

    @Test
    public void testForce() {
        String t = "good morning, liping";
        String p = "liping";
        assertThat(CharacterMatcher.INSTANCE.force(t, p)).isEqualTo(14);
        assertThat(CharacterMatcher.INSTANCE.force(t, "afeter")).isEqualTo(-1);
    }

    @Test
    public void testKmp() {
        String t = "good morning, liping";
        String p = "liping";
        assertThat(CharacterMatcher.INSTANCE.kmp(t, p)).isEqualTo(14);
        assertThat(CharacterMatcher.INSTANCE.kmp(t, "afeter")).isEqualTo(-1);
    }

    @Test
    public void testGetNext() {
        int[] result = CharacterMatcher.INSTANCE.getNext("lilipingli");
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    public void testGetNextUpdate() {
        int[] result = CharacterMatcher.INSTANCE.getNextUpdate("lilipingli");
        Arrays.stream(result).forEach(System.out::println);
    }
}