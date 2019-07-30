package com.example.hackathon.network.client;

import com.example.hackathon.Utils;
import com.example.hackathon.model.Token;
import com.example.hackathon.network.request.WriteRequest;
import com.example.hackathon.network.response.Response;
import com.example.hackathon.network.retrofit.WriteService;

import io.reactivex.Single;

public class WriteClient extends NetworkClient {

    private WriteService writeService;

    public WriteClient() {
        writeService = Utils.RETROFIT.create(WriteService.class);
    }

    public Single<String> write(Token token,WriteRequest writeRequest) {

        return writeService.write(token.getToken(),writeRequest).map(Response::getMessage);
    }
}
