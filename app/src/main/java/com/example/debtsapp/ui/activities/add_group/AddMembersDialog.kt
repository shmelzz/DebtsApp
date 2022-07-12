package com.example.debtsapp.ui.activities.add_group

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddMembersDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = MaterialAlertDialogBuilder(it)
//            val inflater = requireActivity().layoutInflater
//            val addMembersView: View = inflater.inflate(R.layout.dialog_add_members, null)
//            val list: RecyclerView = addMembersView.findViewById(R.id.select_members_rv)
//            list.apply {
//                layoutManager = LinearLayoutManager(context)
//                adapter = AddMembersAdapter(createFriendsListTest())
//            }

            val multiItems = createFriendsListTest()
            val checkedItems = booleanArrayOf(false, false, false, false, false, false)

            builder
                .setPositiveButton("Ok") { _, _ ->
                    dialog?.cancel()
                }
                .setNegativeButton("Cancel") { _, _ ->
                    dialog?.cancel()
                }
                .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
                    // Respond to item chosen
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun createFriendsListTest(): Array<String> {
        return arrayOf(
            "test user 0",
            "test user 1",
            "test user 2",
            "test user 3",
            "test user 4",
            "test user 5"
        )
    }
}