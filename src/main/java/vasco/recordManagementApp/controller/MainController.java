package vasco.recordManagementApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vasco.recordManagementApp.model.Record;
import vasco.recordManagementApp.model.User;
import vasco.recordManagementApp.service.RecordService;
import vasco.recordManagementApp.service.UserService;

import java.util.List;

@Controller
public class MainController {
    private RecordService recordService;
    private UserService userService;
    public MainController(RecordService recordService, UserService userService) {
        super();
        this.recordService = recordService;
        this.userService = userService;
    }
    @GetMapping("/records/u/{uid}")
    public String recordList(@PathVariable Long uid, Model model){
        model.addAttribute("records", recordService.getAllRecordsByUid(uid));
        model.addAttribute("user", userService.getUserById(uid));
        Record record = new Record();
        record.setUser_id(uid);
        model.addAttribute("record", record);
        return "records";
    }
    @GetMapping("/records/new/{uid}")
    public String createRecordForm(@PathVariable Long uid, Model model){
        Record record = new Record();
        record .setUser_id(uid);
        model.addAttribute("record",record);
        return "add_record";
    }
    @PostMapping("/records/u/{uid}")
    public String saveRecord(@PathVariable Long uid, @ModelAttribute("record") Record record) {
        User user = userService.getUserById(uid);
        record.setUser_id(user.getUid());
        recordService.saveRecord(record);
        String Url = "redirect:/records/u/"+uid;
        return Url;
    }
    @GetMapping("/records/edit/{id}")
    public String editRecordForm(@PathVariable Long id, Model model){
        model.addAttribute("record", recordService.getRecordById(id));
        return "edit_record";
    }
    @PostMapping("/records/{id}")
    public String updateRecord(@PathVariable Long id, @ModelAttribute("record") Record record, Model model){
        Record updatableRecord = recordService.getRecordById(id);
        updatableRecord.setName(record.getName());
        updatableRecord.setArtist(record.getArtist());
        updatableRecord.setLabel(record.getLabel());
        updatableRecord.setReleaseYear(record.getReleaseYear());
        updatableRecord.setImageUrl(record.getImageUrl());
        updatableRecord.setSpotify(record.getSpotify());
        recordService.updateRecord(updatableRecord);
        Record record1 = recordService.getRecordById(id);
        Long uid = record1.getUser_id();
        String url = "redirect:/records/u/"+uid;
        return url;
    }
    @GetMapping("/records/{id}")
    public String deleteRecord(@PathVariable Long id){
        Record record = recordService.getRecordById(id);
        Long uId = record.getUser_id();
        String url = "redirect:/records/u/"+uId;
        recordService.deleteRecordById(id);
        return url;
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "registrations";
    }
    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/registration?success";
    }
    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model){
        List<User> users = userService.getAllUsers();

        for(User u: users){
            if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())){
                String url = "redirect:/records/u/"+u.getUid();
                return url;
            }
        }
        return "login";
    }
    @GetMapping("/search/{uid}")
    public String search(@PathVariable Long uid, @ModelAttribute("record") Record record, Model model){
        model.addAttribute("records", recordService.getAllRecordsByArtist(uid, record.getArtist()));
        return "search";
    }
}
