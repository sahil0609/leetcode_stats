package com.org.leetstats.services;

import com.org.leetstats.entities.stats.Codes;
import com.org.leetstats.entities.stats.User_stats;
import com.org.leetstats.enums.InjestExceptionEnum;
import com.org.leetstats.exceptions.InjestException;
import com.org.leetstats.repos.injest.CodeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CodeService {

    private final FileService fileService;
    private final CodeRepo codeRepo;

    public Codes getCodes(User_stats stats, String code){
        Codes codeDAO = new Codes();
        codeDAO.setStats(stats);
        try {
            String target = fileService.createCodes(code);
            codeDAO.setCode_path(target);
        }
        catch(IOException ex){
            log.error("Some error occurred while creating the code file", ex);
            throw new InjestException(InjestExceptionEnum.INTERNAL_SERVER_ERROR,"Some error occurred");
        }

        return codeDAO;

    }

}
