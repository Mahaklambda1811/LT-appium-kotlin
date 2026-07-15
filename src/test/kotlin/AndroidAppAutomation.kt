import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import org.junit.jupiter.api.*
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class AndroidAppAutomation {

    @Test
    public fun sampletest() {
        val username = "mahakgtestmuai"   // set via: $env:LT_USERNAME="..."
        val accessKey = "LT_V4Eb1ykQatzCej6ewT8VuDzioeM4dC9XPAywhMz40Oz8Az9" // set via: $env:LT_ACCESS_KEY="..."

        val hub = URL("https://${username}:${accessKey}@mobile-hub.lambdatest.com/wd/hub")

        val caps = DesiredCapabilities()
        caps.setCapability("autoAcceptAlerts", true)
        caps.setCapability("platformName", "Android")
        caps.setCapability("deviceName", "Galaxy .*")
        caps.setCapability("platformVersion", "11")
        caps.setCapability("platformName", "Android")
        caps.setCapability("isRealMobile", true)
        caps.setCapability("app", "lt://APP1016020861779271846205213") //Add the app (.apk) url here
        caps.setCapability("deviceOrientation", "PORTRAIT")
        caps.setCapability("build", "Kotlin Vanilla - Android")
        caps.setCapability("name", "Sample Test Kotlin")
        caps.setCapability("console", true)
        caps.setCapability("network", false)
        caps.setCapability("visual", true)
        caps.setCapability("devicelog", true)


        val app = AndroidDriver<AndroidElement>(hub, caps)

        Thread.sleep(4000)

        val color: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/color")) as MobileElement
        color.click()

        val text: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/Text")) as MobileElement
        text.click()

        val toast: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/toast")) as MobileElement
        toast.click()

        val notification: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/notification")) as MobileElement
        notification.click()

        val geo: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/geoLocation")) as MobileElement
        geo.click()
        Thread.sleep(5000)

        app.navigate().back()
        Thread.sleep(2000)

        val speedtest: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/speedTest")) as MobileElement
        speedtest.click()
        Thread.sleep(5000)

        app.navigate().back()

        app.quit()

    }
}