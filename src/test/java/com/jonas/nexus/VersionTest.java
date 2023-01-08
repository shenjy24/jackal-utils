package com.jonas.nexus;

import org.junit.Assert;
import org.junit.Test;

public class VersionTest {

    @Test
    public void testVersion() {
        String file = "D:\\java\\workspace\\jackal-utils\\target\\jackal-utils-2.0.0.jar";
        boolean result = VersionChecker.isLatestVersion(file);
        Assert.assertTrue(result);
    }

    @Test
    public void testVersion2() {
        String file = "D:\\java\\workspace\\jackal-utils\\target\\jackal-utils-2.0.0.jar";
        boolean result = VersionCheckerByHttp.isLatestVersion(file);
        Assert.assertTrue(result);
    }
}
