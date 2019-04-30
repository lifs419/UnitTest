package justbon.unittest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);

        assertEquals(testVersion("1.96", "1.97", "1.90"), 3);
        assertEquals(testVersion("1.96", "1.97.0", "1.90"), 3);

        assertEquals(testVersion("1.96.0", "1.97.0", "1.90"), 3);
        assertEquals(testVersion("1.96.0", "1.96.1", "1.90"), 3);
    }


    private int testVersion(String curVersion, String appVersion, String minVersion) {
        int fCurVersion = Integer.valueOf(curVersion.replaceAll("\\.", ""));
        int fMinVersion = Integer.valueOf(minVersion.replaceAll("\\.", ""));
        int fAppVersion = Integer.valueOf(appVersion.replaceAll("\\.", ""));

        if ((fAppVersion > fCurVersion) && (fMinVersion > fCurVersion)) {// 表示强制升级
            return 1;
        } else if ((fAppVersion > fCurVersion) && (fMinVersion <= fCurVersion)) {// 2表示正常升级，弹出框可取消
            return 3;
        }

        return 0;
    }
}