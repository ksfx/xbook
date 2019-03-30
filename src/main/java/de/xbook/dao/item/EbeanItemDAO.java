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

package de.xbook.dao.item;

import de.xbook.dao.user.UserDAO;
import de.xbook.model.item.Item;
import de.xbook.model.user.User;
import io.ebean.Ebean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbeanItemDAO implements ItemDAO
{
    @Override
    public Item getItem(Long id)
    {
        return Ebean.find(Item.class, id);
    }

    @Override
    public List<Item> getAllItems()
    {
        return Ebean.find(Item.class).findList();
    }

    @Override
    public void save(Item item)
    {
        if (item.getId() != null) {
            Ebean.update(item);
        } else {
            Ebean.save(item);
        }
    }

    @Override
    public void delete(Item item)
    {
        Ebean.delete(item);
    }
}
