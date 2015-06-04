package com.alkeste.widget.quotes;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class MyWidgetProvider extends AppWidgetProvider {

	// private static final String ACTION_CLICK = "ACTION_CLICK";

	private String quotes[] = {
			"At the end of the game, pawns and kings go back into the same box",
			"Provide me a track long enough and I shall race against light",
			"Do things will passion, or not at all",
			"Success hugs you in private but failure slaps you in public",
			"You are the best. Remember that. EXCELSIOR!",
			"It does not matter how slowly you go as long as you do not stop",
			"The most certain way to succeed is always to try just one more time",
			"In order to succeed, we must first believe that we can",
			"Either find a way, or make one",
			"Don't watch the clock; do what it does. Keep going",
			"If you fell down yesterday, stand up today",
			"Never give up, for that is just the place and time that the tide will turn",
			"You always have two choices: your commitment versus your fear",
			"Will to succeed as bad as you will to breathe, and you will",
			"The millions you serve matters, not the millions you earn",
			"Everything you ever wanted, is on the other side of fear",
			"Get in the driver's seat of life. Drive yourself",
			"People will always say you can't, say that yourself too?",
			"You're gonna rattle the stars, You ARE!",
			"Magic happens beyond your comfort zone, always",
			"Every dark cloud has a silver lining" };

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {

		// Get all ids
		ComponentName thisWidget = new ComponentName(context,
				MyWidgetProvider.class);
		int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
		for (int widgetId : allWidgetIds) {
			// create some random data
			// int number = (new Random().nextInt(100));
			String quote = getRandomQuote();
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.widget_layout);
			// Log.w("WidgetExample", quote);
			// Set the text
			remoteViews.setTextViewText(R.id.update, quote);

			// Register an onClickListener
			Intent intent = new Intent(context, MyWidgetProvider.class);

			intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

			PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
					0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.update, pendingIntent);
			appWidgetManager.updateAppWidget(widgetId, remoteViews);
		}
	}

	public String getRandomQuote() {
		return quotes[new Random().nextInt(quotes.length)];
	}
}