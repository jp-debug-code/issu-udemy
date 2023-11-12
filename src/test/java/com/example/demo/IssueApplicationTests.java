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
	void myPlaywrightTest(){//作成する


		try(Playwright playwright=Playwright.create()){
				Browser browser= playwright.chromium().launch();
			BrowserContext context = browser.newContext(new Browser.NewContextOptions());
			Page page=context.newPage();
				page.navigate("http://localhost:8080",new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
			page.locator("a").getByText("課題一覧").first().click();
			page.locator("a").getByText("作成").first().click();
			page.locator("#ss").fill("tsssss");
			page.locator("#description").fill("tsssss");
			page.locator(".btn.btn-primary").click();



				}
	}

		@Test
	void test(){ //作成キャンセル
			try(Playwright playwright=Playwright.create()) {
				Browser browser = playwright.chromium().launch();
				BrowserContext context = browser.newContext(new Browser.NewContextOptions());
				Page page = context.newPage();
				page.navigate("http://localhost:8080", new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
				page.locator("a").getByText("課題一覧").first().click();
				page.locator("a").getByText("作成").first().click();
				page.locator("#ss").fill("delete");
				page.locator("#description").fill("tsssss");
				page.locator(".btn.btn-secondary").click();
			}


	}
	@Test
	void test3(){
		try(Playwright playwright=Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			BrowserContext context = browser.newContext(new Browser.NewContextOptions());
			Page page = context.newPage();
			page.navigate("http://localhost:8080", new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
			page.locator("a").getByText("課題一覧").first().click();
			//page.locator("form").getByText("削除").first().click();
			page.locator("form[action='/issues/delete/4']").getByText("削除").first().click();



	}}

}
