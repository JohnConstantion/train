package com.john.train.batch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author JohnConstantine
 * @date 2023/5/14 09:29
 */
@FeignClient("business")
public interface BusinessFeign {

    @GetMapping("/hello")
    String hello();
}
