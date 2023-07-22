package com.mashibing.servicemap.service;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.TerminalResponse;
import com.mashibing.internalcommon.response.TrsearchResponse;
import com.mashibing.servicemap.remote.TerminalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TerminalService {

    @Autowired
    TerminalClient terminalClient;

    public ResponseResult<TerminalResponse> add(String name, String desc) {

        return terminalClient.add(name, desc);
    }

    public ResponseResult<List<TerminalResponse>> aroundsearch(String center, Integer radius) {

        return terminalClient.aroundSearch(center, radius);
    }

    public ResponseResult<TrsearchResponse> trsearch(String tid, Long starttime, Long endtime) {

        return terminalClient.trsearch(tid, starttime, endtime);
    }
}
