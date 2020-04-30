package org.apache.airavata.mft.api.client;

import org.apache.airavata.mft.api.client.MFTApiClient;
import org.apache.airavata.mft.api.service.*;

public class SampleClient {
    public static void main(String args[]) throws InterruptedException {

        MFTApiServiceGrpc.MFTApiServiceBlockingStub client = MFTApiClient.buildClient("149.165.170.106", 31114);

        String sourceId = "local1";
        String sourceToken = "local-ssh-cred";
        String destId = "local2";
        String destToken = "local-ssh-cred";

        TransferApiRequest request = TransferApiRequest.newBuilder()
                .setSourceId(sourceId)
                .setSourceToken(sourceToken)
                .setSourceType("LOCAL")
                .setDestinationId(destId)
                .setDestinationType("LOCAL")
                .setAffinityTransfer(false).build();

        // Submitting the transfer to MFT
        TransferApiResponse transferApiResponse = client.submitTransfer(request);
        while(true) {
            // Monitoring transfer status
            try {
                TransferStateApiResponse transferState = client.getTransferState(TransferStateApiRequest.newBuilder().setTransferId(transferApiResponse.getTransferId()).build());
                System.out.println("Latest Transfer State " + transferState.getState());

            } catch (Exception e) {
                System.out.println("Errored " + e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}