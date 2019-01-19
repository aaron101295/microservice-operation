package Application;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/all")
    public List<Operation> retrouveTousLesComptes() {

        List<Operation> operation = operationRepository.findAll();
        return operation;
    }

    @GetMapping("/byId/{id}")
    public Operation retrouveParId(@PathVariable long id) {
        Optional<Operation> operation = operationRepository.findById(id);
        return operation.get();

    }


    @DeleteMapping("/supprimer/{id}")
    public void supprimerCompte(@PathVariable long id) {
        operationRepository.deleteById(id);
    }

    @PostMapping("/creer")
    public ResponseEntity<Object> creerCompte(@RequestBody Operation operation) {
        Operation operationCree = operationRepository.save(operation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(operationCree.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/MAJOperation/{id}")
    public ResponseEntity<Object> majCompte(@RequestBody Operation operation, @PathVariable long id) {

        Optional<Operation> operationOptional = operationRepository.findById(id);

        if (!operationOptional.isPresent())
            return ResponseEntity.notFound().build();

        operation.setId(id);

        operationRepository.save(operation);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/afficherCompte",method = {RequestMethod.GET})
    public List<Compte> afficherCompte() {


       List<Compte> compte = new ArrayList<Compte>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://192.168.99.100:8000/compte/all",List.class);

        compte = responseEntity.getBody();


        System.out.println(compte.toString());
        return compte;
    }

    @GetMapping("/byType/{type}")
    public Operation operationParType (@PathVariable String type) {
        Operation operation = operationRepository.findByType(type);
        return operation;
    }

    @GetMapping("/source/{ibansource}/dest/{ibandest}")
    public Operation operationParIbanSourceAndDest (@PathVariable String ibansource, @PathVariable String ibandest) {
        Operation operation = operationRepository.findByIbansourceAndIbandest(ibansource, ibandest);

        System.out.println(ibansource);
        return operation;
    }


    @RequestMapping(value="/bydate" , method=RequestMethod.GET)
    public Operation opertaionParDate(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        Operation operation = operationRepository.findByDate(date);
        System.out.println(date);
        return operation;
    }

    @RequestMapping(value="/retirer")
    public static void retirerArgent(@RequestParam("montant") Double montant,@RequestParam long id){

        final String uri = "http://localhost:8000/compte/retirer/"+id;


        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("montant", montant.toString());

        HttpEntity<MultiValueMap<String, String>> requestEntity= new HttpEntity<MultiValueMap<String, String>>(map, headers);

        template.put(uri, requestEntity,  HashMap.class);
    }

    @RequestMapping(value="/deposer")
    public static void deposerArgent(@RequestParam("montant") Double montant,@RequestParam long id){

        final String uri = "http://localhost:8000/compte/deposer/"+id;


        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("montant", montant.toString());

        HttpEntity<MultiValueMap<String, String>> requestEntity= new HttpEntity<MultiValueMap<String, String>>(map, headers);

        template.put(uri, requestEntity,  HashMap.class);
    }


    @RequestMapping(value="/virement")
    public static void faireUnVirement(@RequestParam("montant") Double montant,@RequestParam long id1, @RequestParam long id2){

        final String uri = "http://localhost:8000/compte/virement/"+id1+"/"+id2;


        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("montant", montant.toString());

        HttpEntity<MultiValueMap<String, String>> requestEntity= new HttpEntity<MultiValueMap<String, String>>(map, headers);

        template.put(uri, requestEntity,  HashMap.class);

    }



}
