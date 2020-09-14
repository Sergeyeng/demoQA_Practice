package demoqa;

/*
 * Test suite different pages
 * on https://demoqa.com
 */

import demoqa.accordian.Accordian;
import demoqa.actionButton.ActionButton;
import demoqa.alerts.Alerts;
import demoqa.brokenLinkAndImage.BrokenLinkAndImage;
import demoqa.dynamicProperties.DynamicProperties;
import demoqa.links.Links;
import demoqa.radioButton.RadioButton;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        // Initialization.class,
        Accordian.class,
        ActionButton.class,
        Alerts.class,
        BrokenLinkAndImage.class,
        DynamicProperties.class,
        Links.class,
        RadioButton.class
})

public class TestSuite {
}
