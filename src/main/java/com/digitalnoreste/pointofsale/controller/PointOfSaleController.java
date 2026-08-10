package com.digitalnoreste.pointofsale.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PointOfSaleController {

  public PointOfSaleController() {
  }

  @GetMapping("/")
  public String testGetEndpoint() {

    log.info("Requested Liveliness check.");
    return "Successful GET to DN Point of Sale";
  }

}
