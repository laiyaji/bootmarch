package spring.boot.example.bootmarch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SSCController {

	@RequestMapping("toSeeLine")
	public void toSeeLine() {

		System.out.println("查看时时彩");


	}
}
