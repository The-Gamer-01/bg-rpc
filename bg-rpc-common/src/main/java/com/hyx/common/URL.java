package com.hyx.common;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyx
 **/

@Data
public class URL {
    private final String protocol;
    
    private final String host;
    
    private final int port;
    
    private final String path;
    
    private final Map<String, String> parameters;
    
    public URL() {
        this.protocol = null;
        this.host = null;
        this.port = 0;
        this.path = null;
        this.parameters = null;
    }
    
    public URL(String protocol, String host, int port, String path, Map<String, String> parameters) {
        this.protocol = protocol;
        this.host = host;
        this.port = (port < 0 ? 0 : port);
        this.path = path;
        if (parameters == null) {
            parameters = new HashMap<>();
        } else {
            parameters = new HashMap<>(parameters);
        }
        this.parameters = Collections.unmodifiableMap(parameters);
    }
    
    @Override
    public String toString() {
        return buildString();
    }
    
    private String buildString() {
        StringBuilder builder = new StringBuilder();
        if (protocol != null && protocol.length() > 0) {
            builder.append(protocol);
            builder.append("://");
        }
        if (host != null && host.length() > 0) {
            builder.append(host);
            if (port > 0) {
                builder.append(":");
                builder.append(port);
            }
        }
        if (path != null && path.length() > 0) {
            builder.append("/");
            builder.append(path);
        }
        if (getParameters() != null) {
            boolean first = true;
            for (Map.Entry<String, String> entry : getParameters().entrySet()) {
                if (entry.getKey() != null && entry.getKey().length() > 0) {
                    if (first) {
                        builder.append("?");
                        first = false;
                    } else {
                        builder.append("&");
                    }
                    builder.append(entry.getKey());
                    builder.append("=");
                    builder.append(entry.getValue() == null ? "" : entry.getValue().trim());
                }
            }
        }
        return builder.toString();
    }
    
}
