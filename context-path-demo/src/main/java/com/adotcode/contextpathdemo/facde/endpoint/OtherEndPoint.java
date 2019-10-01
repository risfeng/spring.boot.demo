package com.adotcode.contextpathdemo.facde.endpoint;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo endpoint
 *
 * @author risfeng
 * @date 2019/09/26
 */
@RestController
@RequestMapping("/v1")
public class OtherEndPoint {

  @GetMapping("/users")
  public ResponseEntity<Map<String, String>> getUsers() {
    Map<String, String> result = new HashMap<>(10);
    result.put("userId", UUID.randomUUID().toString());
    result.put("userName", "StringUtils.");
    result.put("pwd", "ABC*****GD");
    return ResponseEntity.ok(result);
  }
}
