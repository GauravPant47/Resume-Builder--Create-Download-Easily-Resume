// package net.resume.building.config;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import net.resume.building.model.Account;
// import net.resume.building.model.Authority;
// import net.resume.building.repositorty.AuthorityRepository;
// import net.resume.building.service.AccountService;

// @Component
// public class SeedData implements CommandLineRunner {

// @Autowired
// private AccountService accountService;

// @Autowired
// private AuthorityRepository authorityRepository;

// @Override
// public void run(String... args) throws Exception {
// // TODO Auto-generated method stub

// Authority user = new Authority();
// user.setName("USER");
// authorityRepository.save(user);

// Authority admin = new Authority();
// admin.setName("ADMIN");
// authorityRepository.save(admin);

// Account account = new Account();

// account.setFullName("Gaurav Pant");
// account.setGender("Male");
// account.setDob("03-01-1998");
// account.setEmail("Admin.Gaurav@gmail.com");
// account.setPassword("admin796Gaurav");
// Set<Authority> authorities = new HashSet<>();
// authorityRepository.findById("ADMIN").ifPresent(authorities::add);
// account.setAuthorities(authorities);

// accountService.save(account);

// }

// }
