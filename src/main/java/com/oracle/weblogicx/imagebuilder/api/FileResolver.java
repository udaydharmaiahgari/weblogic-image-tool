package com.oracle.weblogicx.imagebuilder.api;

import com.oracle.weblogicx.imagebuilder.api.meta.CacheStore;

public interface FileResolver {

    /**
     * Given a cache store, check whether the installer / patch file exists on disk.
     * patch files will be downloaded as required.
     *
     * @param cacheStore store that keeps track of required artifacts
     * @return location of file on disk if found
     * @throws Exception in case of error
     */
    String resolve(CacheStore cacheStore) throws Exception;

}