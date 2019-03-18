/* Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved. 
*                                                              
* Licensed under the Universal Permissive License v 1.0 as shown at http://oss.oracle.com/licenses/upl. 
*/
package com.oracle.weblogicx.imagebuilder.cli.cache;

import com.oracle.weblogicx.imagebuilder.api.meta.CacheStore;
import com.oracle.weblogicx.imagebuilder.api.model.CommandResponse;
import com.oracle.weblogicx.imagebuilder.impl.meta.CacheStoreFactory;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Unmatched;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class CacheOperation implements Callable<CommandResponse> {

    boolean isCLIMode;

    CacheOperation() {
    }

    CacheOperation(boolean isCLIMode) {
        this.isCLIMode = isCLIMode;
    }

    //    @Option(
//            names = {"--cacheStoreType"},
//            description = "Whether to use file backed cache store or preferences backed cache store. Ex: file or pref",
//            hidden = true,
//            defaultValue = "file"
//    )
    protected CacheStore cacheStore = new CacheStoreFactory().get();

    @Unmatched
    List<String> unmatchedOptions = new ArrayList<>();

    @Spec
    CommandSpec spec;
}
