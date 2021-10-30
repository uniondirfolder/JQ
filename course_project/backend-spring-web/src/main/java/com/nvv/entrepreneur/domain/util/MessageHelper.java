package com.nvv.entrepreneur.domain.util;

import com.nvv.entrepreneur.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
