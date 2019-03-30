/**
 *
 * Copyright (C) 2011-2017 KSFX. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.xbook.dao.media;

import de.xbook.dao.item.ItemDAO;
import de.xbook.model.item.Item;
import de.xbook.model.media.Media;
import io.ebean.Ebean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbeanMediaDAO implements MediaDAO
{
    @Override
    public Media getMedia(Long id)
    {
        return Ebean.find(Media.class, id);
    }

    @Override
    public List<Media> getAllMedias()
    {
        return Ebean.find(Media.class).findList();
    }

    @Override
    public void save(Media media)
    {
        if (media.getId() != null) {
            Ebean.update(media);
        } else {
            Ebean.save(media);
        }
    }

    @Override
    public void delete(Media media)
    {
        Ebean.delete(media);
    }
}
