package com.Octopussaass.WebdriverUtility;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

/**
 * Small verification helper that provides two kinds of methods:
 * - verifyTrue/verifyFalse/verifyEquals: record a verification to Extent as VERIFICATION and continue (no assertion thrown)
 * - assertVerifyTrue/assertVerifyFalse/assertVerifyEquals: record the verification and then assert (fail fast)
 *
 * This ensures all verifications are present in the Advance report with a clear 'VERIFICATION' label.
 */
public class Verification {

    private static String VERIFICATION_LABEL = "VERIFICATION";

    // record verification as pass or fail but do NOT throw
    public static void verifyTrue(boolean condition, String message) {
        if (condition) {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [PASS]");
        } else {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [FAIL]");
        }
    }

    public static void verifyFalse(boolean condition, String message) {
        verifyTrue(!condition, message);
    }

    public static void verifyEquals(Object actual, Object expected, String message) {
        boolean pass = (actual == null && expected == null) || (actual != null && actual.equals(expected));
        if (pass) {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [PASS] - expected: " + expected + " actual: " + actual);
        } else {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [FAIL] - expected: " + expected + " actual: " + actual);
        }
    }

    // assert + record (fail fast)
    public static void assertVerifyTrue(boolean condition, String message) {
        if (condition) {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [PASS]");
        } else {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [FAIL]");
        }
        Assert.assertTrue(condition, message);
    }

    public static void assertVerifyFalse(boolean condition, String message) {
        assertVerifyTrue(!condition, message);
    }

    public static void assertVerifyEquals(Object actual, Object expected, String message) {
        boolean pass = (actual == null && expected == null) || (actual != null && actual.equals(expected));
        if (pass) {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [PASS] - expected: " + expected + " actual: " + actual);
        } else {
            utilityclassobject.gettest().log(Status.INFO, VERIFICATION_LABEL + ": " + message + " - [FAIL] - expected: " + expected + " actual: " + actual);
        }
        Assert.assertEquals(actual, expected, message);
    }
}
