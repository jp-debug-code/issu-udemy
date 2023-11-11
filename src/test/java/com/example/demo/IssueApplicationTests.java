package com.example.demo;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.microsoft.playwright.Browser.*;


@SpringBootTest
class IssueApplicationTests {

	@Test
	void myPlaywrightTest(){


		try(Playwright playwright=Playwright.create()){
				Browser browser= playwright.chromium().launch();
			BrowserContext context = browser.newContext(new Browser.NewContextOptions());
			Page page=context.newPage();
				page.navigate("http://localhost:8080",new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
			page.locator("a").getByText("課題一覧").first().click();




				}



	}

}
