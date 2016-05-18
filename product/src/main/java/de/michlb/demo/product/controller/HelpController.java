package de.michlb.demo.product.controller;

import de.michlb.demo.product.constant.ApiConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import de.michlb.demo.product.constant.GlobalBusinessCodes;

/**
 * <pre>
 *      Controller provides clients with a definitive list of all HTTP and Business codes.
 * </pre>
 */
@RestController
public class HelpController {

    private Map<Object, String> businessCodes = new HashMap<>();
    private Map<Object, String> httpCodes = new HashMap<>();
    private Map<String, Map<Object, String>> codes = new HashMap<>();


    @PostConstruct
    public void setup(){

        for(GlobalBusinessCodes code : GlobalBusinessCodes.values()) {
            businessCodes.put(code.getCode(), code.getDescription());
        }

        codes.put("businessCodes", businessCodes);


        for(HttpStatus httpStatus : HttpStatus.values()) {
            httpCodes.put(httpStatus.value(), httpStatus.getReasonPhrase());
        }

        codes.put("httpCodes", httpCodes);
    }

    @RequestMapping(path = ApiConstants.API_HELP)
    public ResponseEntity help(){
        return new ResponseEntity(codes, HttpStatus.OK);
    }
}
