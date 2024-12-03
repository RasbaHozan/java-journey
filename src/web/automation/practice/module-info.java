
module journey {

	requires java.base;
	requires org.seleniumhq.selenium.api;
	requires org.seleniumhq.selenium.chrome_driver;
	requires io.github.bonigarcia.webdrivermanager;
	requires org.testng;
    requires org.seleniumhq.selenium.remote_driver;
    requires org.tomlj;
	requires org.seleniumhq.selenium.support;
	requires org.seleniumhq.selenium.firefox_driver;
	requires org.junit.jupiter.api;
	requires junit;
	requires com.google.gson;
    exports web.automation.practice;
	}