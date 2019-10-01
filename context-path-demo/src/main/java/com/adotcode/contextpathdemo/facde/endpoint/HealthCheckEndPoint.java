package com.adotcode.contextpathdemo.facde.endpoint;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo endpoint
 *
 * @author risfeng
 * @date 2019/09/26
 */
@RestController
public class HealthCheckEndPoint {

  @GetMapping("/status")
  public ResponseEntity<Map<String, String>> getStatus() {
    Map<String, String> result = new HashMap<>(10);
    result.put("commit", UUID.randomUUID().toString());
    result.put("date", new Date().toString());
    result.put("status", "1");
    return ResponseEntity.ok(result);
  }
}
