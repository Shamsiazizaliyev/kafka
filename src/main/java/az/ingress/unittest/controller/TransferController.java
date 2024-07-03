package az.ingress.unittest.controller;

import az.ingress.unittest.dto.Transfer;
import az.ingress.unittest.service.TransferService;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;


@PostMapping
public String test(){
    return "test";
}


//    @GetMapping("/{id}")
//    public ResponseEntity<Transfer> getTransfer(@PathVariable Long id) {
//      return ResponseEntity.status(OK).body(transferService.getTransfer(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Transfer> postTransfer(@RequestBody Transfer transfer) {
//      return ResponseEntity.status(CREATED).body(transferService.postTransfer(transfer));
//    }

    @PostMapping("/{name}")
    public ResponseEntity<String> producesString(@PathVariable String name) {
      return ResponseEntity.ok(transferService.producesString(name));

  }


  ////////////////

//  @GetMapping("/{id}")
// // @RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<Transfer> getTransfer(@PathVariable  Long id){
//
//
//      return ResponseEntity.status(OK).body(transferService.getTranfer(id));
//  }
//
//  @PostMapping
//  public ResponseEntity<Transfer> postTransfer(@RequestBody  Transfer transfer){
//
//
//    return ResponseEntity.status(OK).body(transferService.postTranfer(transfer));
//  }
}
