package com.github.jreddit.utils.restclient.methodbuilders;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicHeader;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class HttpMethodBuilder<T extends HttpMethodBuilder<?, ?>, O extends HttpRequestBase> {

    protected final List<Header> headers = new ArrayList<Header>();
    protected URI uri;

	public T withUrl(String url) throws URISyntaxException {
        this.uri = new URI(url);
        @SuppressWarnings("unchecked")
        T returns = (T) this;
        return returns;
    }

    public T withCookie(String cookie) {
        if (cookie != null && !cookie.isEmpty()) {
            headers.add(new BasicHeader("cookie", "reddit_session=" + cookie));
        }
        @SuppressWarnings("unchecked")
        T returns = (T) this;
        return returns;
    }

    public T withUserAgent(String userAgent) {
        headers.add(new BasicHeader("User-Agent", userAgent));
        @SuppressWarnings("unchecked")
        T returns = (T) this;
        return returns;
    }

    public abstract O build();
}
