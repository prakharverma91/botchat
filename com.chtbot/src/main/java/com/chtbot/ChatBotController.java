package com.chtbot;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ChatBotController-controller", description = "Operation pertaining to kycdocument")

@RestController
@RequestMapping("/api/v1")
public class ChatBotController {

	private static final Logger logger = LoggerFactory.getLogger(ChatBotController.class);

	@Autowired
	private ChatBotService chatBotService;
	@ApiOperation(value = "Api for Adding New KycDocument in Starin App", response = ResponseEntity.class)
	@RequestMapping(value = "/chatbot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Object> sendChatBot(

			@Valid @RequestBody Req_SendChatBot req_SendChatBot, BindingResult result) {
		logger.debug("inside sendChatBot api");

		if (result.hasErrors())
			return ChatBotUtility.getErrorResponse("Field error",null);

		String botResponse = chatBotService.init(req_SendChatBot.getInputText());
		//	Map<String, Object> response = kycDocumentService.addNewKycDocument(req_AddKycDocument);

		logger.debug("sendChatBot api returning successfully");
		return ChatBotUtility.getSuccessResponse("chat bot successfull", botResponse);
	}


}
