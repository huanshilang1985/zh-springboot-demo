package com.zh.doc;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author he.zhang
 * @date 2020/6/16 9:25
 */
@SpringBootApplication
public class DocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class, args);

        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\workspace\\zh-springboot-demo\\zh-springboot-api"); // 项目根目录
        config.setProjectName("zh-api"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\files\\doc"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档

        System.out.println("启动成功===========");



    }

}
