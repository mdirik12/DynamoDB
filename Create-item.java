package com.amazonaws.codesamples.document;
import java.io.IOExpection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.service.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.service.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.service.dynamodbv2.document.DynamoDB;
import com.amazonaws.service.dynamodbv2.document.Item;
import com.amazonaws.service.dynamodbv2.document.Table;

import com.amazonaws.service.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.service.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.service.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.service.dynamodbv2.document.utils.NameMap;
import com.amazonaws.service.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.service.dynamodbv2.model.ReturnValue;

