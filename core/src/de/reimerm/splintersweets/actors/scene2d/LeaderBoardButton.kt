/*
 * Copyright (c) 2017. Marius Reimer
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

package de.reimerm.splintersweets.actors.scene2d

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import de.reimerm.splintersweets.main.MainGame
import de.reimerm.splintersweets.screens.HighscoreScreen
import de.reimerm.splintersweets.utils.AssetsManager
import de.reimerm.splintersweets.utils.GameManager
import de.reimerm.splintersweets.utils.Resources
import java.util.*

/**
 * Created by Marius Reimer on 07-Oct-16.
 */
class LeaderBoardButton : ImageButton {

    constructor(imageUp: Drawable = TextureRegionDrawable(AssetsManager.textureMap[Resources.RegionNames.BUTTON_LEADERBOARD.name])) : super(imageUp) {
        addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                if (Gdx.app.type == Application.ApplicationType.iOS) {
                    MainGame.screen = HighscoreScreen(LinkedHashMap<String, String>(), false)
                }
                GameManager.listener?.displayLeaderBoard()
            }
        })
    }
}